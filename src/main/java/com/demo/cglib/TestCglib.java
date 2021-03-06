package com.demo.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by yangyuan on 16-5-24.
 */
public class TestCglib {

    public static void main(String[] args) {
       // Programmer progammer = new Programmer();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/home/yangyuan/cglib_test");
        Hacker hacker = new Hacker();
        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(Programmer.class);
        // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(hacker);
        Programmer proxy =(Programmer)enhancer.create();//proxy这个动态代理对象和Hacker的intercept 的obj是一个对象
        proxy.code();
        //ProxyUtils.generateClassFile(proxy.getClass(), "ProgrammerProxy");
    }
}
