package com.demo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yangyuan on 16-5-17.
 */
public class DynamicProxy implements InvocationHandler {
    private Object subject;

    // 构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object obj){
        this.subject = obj;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable {
        // 在代理真实对象操作前 我们可以添加一些自己的操作
        System.out.println("before proxy invoke");

        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object result = method.invoke(subject, args);

        // 在代理真实对象操作后 我们也可以添加一些自己的操作
        System.out.println("after proxy invoke");
        return result;
    }
}
