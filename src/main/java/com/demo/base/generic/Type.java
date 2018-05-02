package com.demo.base.generic;

/**
 * Created by yangyuan on 4/16/18.
 */
public class Type {
    public static void main(String[] args) {
        int a = 123;
        hello(a);//a 装箱为Integer了.
    }

    private static <T> void hello(T t){
        System.out.println(t);
    }
}
