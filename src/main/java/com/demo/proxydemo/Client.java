package com.demo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by yangyuan on 16-5-17.
 */
public class Client {
    public static void main(String[] args) {
        // 我们要代理的真实对象
        Subject realSubject = new RealSubject();
        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象调用方法的
        InvocationHandler handler = new DynamicProxy(realSubject);
        /*
         * 通过Proxy的newProxyInstance方法来动态创建我们的代理对象，我们来看看其三个参数<
         * 参数一：我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 参数二：我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 参数三：我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                RealSubject.class.getInterfaces(),
                handler);

       // System.out.println(proxyInstance.getClass().getName());
        System.out.println(proxyInstance.visit());

    }
}
