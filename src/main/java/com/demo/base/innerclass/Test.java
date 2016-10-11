package com.demo.base.innerclass;

/**
 * Created by yangyuan on 16-9-6.
 */
public class Test {
    public static void main(String[] args) {
        TestDemo.InnerClass innerClass = new TestDemo().new InnerClass();
        innerClass.getMessage();
        System.out.println("aa"+(Object)null);

    }
}
