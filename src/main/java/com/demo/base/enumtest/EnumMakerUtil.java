package com.demo.base.enumtest;

/**
 * Created by yangyuan on 2019/3/8.
 *
 * @author yangyuan
 * @date 2019/03/08
 */
public class EnumMakerUtil {

    /**
     * Integer.class 不能写成int.class
     */
    private static Class[] METHOD_PARAM_CLASS = new Class[]{Integer.class, String.class, String.class};

    public static String testAdd() {
        String name = "ADDTEST";
        Object[] value = new Object[3];
        value[0] = 3;
        value[1] = "AddTest";
        value[2] = "新增枚举";
        EnumMaker.addEnum(TestEnum.class, name, METHOD_PARAM_CLASS, value);
        return name;
    }

    public static String testAdd2() {
        String name = "ADDTEST2";
        Object[] value = new Object[3];
        value[0] = 3;
        value[1] = "AddTest2";
        value[2] = "新增枚举2";
        EnumMaker.addEnum(TestEnum.class, name, METHOD_PARAM_CLASS, value);
        return name;
    }

    public static void testSwitch() {
        for (TestEnum testEnum : TestEnum.values()) {
            try {
                switch (testEnum) {
                    case TEST1:
                    case TEST2:
                        System.out.println(" ++++ " + testEnum.getDesc() + " ++++ ");
                        break;
                    default:
                        System.out.println(" ++++ " + testEnum.getDesc() + " ++++ ");
                        break;
                }
            } catch (Exception e) {
                System.out.println("我抛异常了：" + testEnum.getDesc());
                e.printStackTrace();
            }
        }
    }

    public static String testUpdate() {
        String name = "ADDTEST";
        Object[] value = new Object[3];
        value[0] = 3;
        value[1] = "AddTest";
        value[2] = "新增枚举";
        EnumMaker.updateEnum(TestEnum.class, name, METHOD_PARAM_CLASS, value);
        return name;
    }

    public static String testUpdate2() {
        String name = "ADDTEST2";
        Object[] value = new Object[3];
        value[0] = 3;
        value[1] = "AddTest2";
        value[2] = "新增枚举2";
        EnumMaker.updateEnum(TestEnum.class, name, METHOD_PARAM_CLASS, value);
        return name;
    }

    public static void testSave() {
        // 预留位置 以特殊字符$开头标示空位
        for (int i = 0; i < 3; i++) {
            EnumMaker.addEnum(TestEnum.class, "$" + i, METHOD_PARAM_CLASS, new Object[3]);
        }
    }
}
