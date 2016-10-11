package com.demo.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by yangyuan on 16-9-22.
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/home/yangyuan/cglib_test");
        Hacker hacker = new Hacker();
        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(hacker);
        HelloImpl proxy =(HelloImpl)enhancer.create();
        proxy.sayHello();
        //ProxyUtils.generateClassFile(proxy.getClass(), "DanamicGener");
    }
}
