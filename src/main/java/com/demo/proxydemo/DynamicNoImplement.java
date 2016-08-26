package com.demo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yangyuan on 16-7-28.
 */
public class DynamicNoImplement implements InvocationHandler {
    @Override
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable {
        return null;
    }
}
