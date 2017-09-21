package com.demo.base.inherit;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yangyuan on 8/18/17.
 */
public class MyMethodInterceptor implements MethodInterceptor{
    private Object target;

    public MyMethodInterceptor(Object targe){
        this.target = targe;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before :" + method);
        //Object object = methodProxy.invokeSuper(o, objects);//代理对象的方法调用
        Object object = method.invoke(target,objects);//目标对象的执行
        System.out.println("After :" + method);
        return object;
    }
}
