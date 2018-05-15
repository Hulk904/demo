package com.demo.base.reflect.without_set;

import java.lang.reflect.Field;

/**
 * 设置没有set方法的属性--反射
 * 之前可能就记得反射调用private的方法，通过反射也可以直接操作private属性
 * Created by yangyuan on 5/15/18.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        JavaBean jb = new JavaBean();
        Field field = jb.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(jb, "yangyuan");
        Field age = jb.getClass().getDeclaredField("age");
        age.setAccessible(true);
        age.set(jb, 45);
        System.out.println(jb.toString());
    }
}
