package com.demo.base.reflect.final_modify;

import java.lang.reflect.Field;

/**
 * Created by yangyuan on 12/26/17.
 * 在不改变string变量指向的情况下修改字符串里面的值
 */
public class StringDemo {

    public static void main(String[] args) throws Exception {
        String str01 = "aaa";
        String str02 = "aaa";
        String str03 = "bbbb";
        System.out.println(str01.hashCode() + "/" + str02.hashCode() + "/" + str03.hashCode());
        Field field = str02.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(str02,new char[] { 'b', 'b', 'b', 'b'});
        System.out.println(str01 + "/" + str02);//str01 和 str02 一样 ，说明两个指向同一个区域
//        field = str02.getClass().getDeclaredField("count");
//        field.setAccessible(true);
//        field.set(str02,4);

        System.out.println(str01 + "/" + str02);
        System.out.println(str01.hashCode() + "/" + str02.hashCode() + "/" + str03.hashCode());
        field = str02.getClass().getDeclaredField("hash");
        field.setAccessible(true);
        field.set(str02,0);
        System.out.println(str01.hashCode() + "/" + str02.hashCode() + "/" + str03.hashCode());
        System.out.println(str01 == str02);
        System.out.println(str02 == str03);//返回false 虽然hashcode和内容一样，但是是两个不同的对象
    }
}
