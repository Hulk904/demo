package com.demo.base.design_pattern.decorate;

/**
 * Created by yangyuan on 1/30/18.
 */
public class Decorate2 extends Decorate{

    public Decorate2(Human human) {
        super(human);
    }

    public void fun1(){
        System.out.println("do wear thing");
    }

    public void fun2(){
        System.out.println("walk ting a ");
    }

    @Override
    public void wearCloser(){
        super.wearCloser();
        fun1();
    }

    @Override
    public void walkToWhere(){
        super.walkToWhere();
        fun2();
    }
}
