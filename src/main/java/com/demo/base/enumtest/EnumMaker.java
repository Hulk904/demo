package com.demo.base.enumtest;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.reflect.ConstructorAccessor;
import sun.reflect.FieldAccessor;
import sun.reflect.ReflectionFactory;

/**
 * Created by yangyuan on 2019/3/8.
 *
 * @author yangyuan
 * @date 2019/03/08
 */
public class EnumMaker {

    private static ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();


    public static <T extends Enum<?>> void addEnum(Class<T> enumType, String enumName, Class<?>[] paramClass,
                                                   Object[] paramValue) {

        // 检查是否为枚举类型
        if (!Enum.class.isAssignableFrom(enumType)) {
            throw new RuntimeException("class " + enumType + " is not an instance of Enum");
        }

        // 获取$VALUES field
        Field valuesField = null;
        Field[] fields = enumType.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().contains("$VALUES")) {
                valuesField = field;
                break;
            }
        }
        AccessibleObject.setAccessible(new Field[] {valuesField}, true);

        try {
            // 获取$VALUES的值  放到previousValues数组中
            T[] previousValues = (T[])valuesField.get(enumType);

            // 根据name去重 避免添加了重复的name
            for (T value : previousValues) {
                if (value.toString().equals(enumName)) {
                    return;
                }
            }

            // previousValues数组转换为values list 便于操作
            List<T> values = new ArrayList<T>(Arrays.asList(previousValues));

            // 构建一个新的枚举
            T newValue = (T)makeEnum(enumType,
                enumName,
                values.size(),
                paramClass,
                paramValue
            );

            // 将新的枚举添加到values中
            values.add(newValue);
            // 将values转换为数组 重新set到$VALUES中
            Object object = values.toArray((T[])Array.newInstance(enumType, 0));
            setFailsafeFieldValue(valuesField, null, object);

            // 清理缓存
            cleanEnumCache(enumType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Object makeEnum(Class<?> enumClass, String value, int ordinal, Class<?>[] additionalTypes,
                                  Object[] additionalValues) throws Exception {
        Object[] parms = new Object[additionalValues.length + 2];
        parms[0] = value;
        parms[1] = Integer.valueOf(ordinal);
        System.arraycopy(additionalValues, 0, parms, 2, additionalValues.length);
        return enumClass.cast(getConstructorAccessor(enumClass, additionalTypes).newInstance(parms));
    }

    private static ConstructorAccessor getConstructorAccessor(Class<?> enumClass, Class<?>[] additionalParameterTypes)
        throws NoSuchMethodException {
        Class<?>[] parameterTypes = new Class[additionalParameterTypes.length + 2];
        parameterTypes[0] = String.class;
        parameterTypes[1] = int.class;
        System.arraycopy(additionalParameterTypes, 0, parameterTypes, 2, additionalParameterTypes.length);
        return reflectionFactory.newConstructorAccessor(enumClass.getDeclaredConstructor(parameterTypes));
    }

    private static void cleanEnumCache(Class<?> enumClass) throws NoSuchFieldException, IllegalAccessException {
        blankField(enumClass, "enumConstants"); // IBM JDK
        blankField(enumClass, "enumConstantDirectory"); // Sun (Oracle?!?) JDK 1.5/6
    }

    private static void blankField(Class<?> enumClass, String fieldName) throws NoSuchFieldException,
        IllegalAccessException {
        for (Field field : Class.class.getDeclaredFields()) {
            if (field.getName().contains(fieldName)) {
                AccessibleObject.setAccessible(new Field[] {field}, true);
                setFailsafeFieldValue(field, enumClass, null);
                break;
            }
        }
    }

    private static void setFailsafeFieldValue(Field field, Object target, Object value) throws NoSuchFieldException,
        IllegalAccessException {

        // 设置字段acessible
        field.setAccessible(true);
        // 修改final类型 从而可以修改final类型的值
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);
        modifiers &= ~Modifier.FINAL;
        modifiersField.setInt(field, modifiers);

        FieldAccessor fa = reflectionFactory.newFieldAccessor(field, false);
        fa.set(target, value);
    }

    public static <T extends Enum<?>> void updateEnum(Class<T> enumType, String enumName, Class<?>[]
        paramClass, Object[] paramValue) {

        // 检查是否为枚举类型
        if (!Enum.class.isAssignableFrom(enumType)) {
            throw new RuntimeException("class " + enumType + " is not an instance of Enum");
        }

        // 取出$VALUES值
        Field valuesField = null;
        Field[] fields = enumType.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().contains("$VALUES")) {
                valuesField = field;
                break;
            }
        }
        AccessibleObject.setAccessible(new Field[] {valuesField}, true);

        try {

            T[] previousValues = (T[])valuesField.get(enumType);

            // 取出预留的空位 将新枚举的值覆盖 注意保留空位的ordinal
            for (int i = 0; i < previousValues.length; i++) {
                if (previousValues[i].toString().equals(enumName)) {
                    return;
                } else if (previousValues[i].toString().startsWith("$")) {
                    T newValue = (T)makeEnum(enumType,
                        enumName,
                        previousValues[i].ordinal(),
                        paramClass,
                        paramValue
                    );
                    previousValues[i] = newValue;
                    break;
                }
            }

            // 清理缓存
            cleanEnumCache(enumType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
