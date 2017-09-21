package com.demo.base.inherit;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by yangyuan on 8/19/17.
 */
public class SpringCglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AbstractClass.class);
        AbstractClass concretClass = new ConcretClass();
        concretClass.setName("concret");
        enhancer.setCallback(new SpringCallBack(concretClass));
        AbstractClass ab = (AbstractClass)enhancer.create();
        ab.sayHello();
    }
}
