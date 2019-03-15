package com.demo.base.enumtest;

import java.util.Arrays;

/**
 * Created by yangyuan on 2019/3/8.
 * 动态添加枚举
 * @author yangyuan
 * @date 2019/03/08
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(TestEnum.values()));
        System.out.println("枚举长度： " +  TestEnum.values().length);

        System.out.println("============");
        String name = EnumMakerUtil.testAdd();
        System.out.println(Arrays.deepToString(TestEnum.values()));
        System.out.println("枚举长度：" + TestEnum.values().length);
        TestEnum testEnum = TestEnum.getByName(name);
        System.out.println(testEnum.toPrintString());
    }
}
