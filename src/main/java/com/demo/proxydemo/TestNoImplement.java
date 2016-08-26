package com.demo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by yangyuan on 16-7-28.
 */
public class TestNoImplement {
    public static void main(String[] args) {
        InvocationHandler handler = new DynamicNoImplement();
        NoImplement noImplement = (NoImplement) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                new Class[]{NoImplement.class},handler);
        System.out.println(noImplement.hello());
        int a= 3 +6;
        System.out.println(a);
    }
}
