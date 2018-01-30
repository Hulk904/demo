package com.demo.base.design_pattern.decorate;

/**
 * Created by yangyuan on 1/30/18.
 */
public class Person implements Human{

    @Override
    public void wearCloser() {
        System.out.println("穿衣服。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪儿。");
    }
}
