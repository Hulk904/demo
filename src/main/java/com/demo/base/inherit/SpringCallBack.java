package com.demo.base.inherit;





import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yangyuan on 8/19/17.
 */
public class SpringCallBack implements MethodInterceptor {

    private Object target;

    public SpringCallBack(Object object){
        this.target = object;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object object = methodProxy.invokeSuper(o,objects);
        return object;
    }
}
