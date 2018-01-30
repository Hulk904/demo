package com.demo.base.design_pattern.decorate;

/**
 * Created by yangyuan on 1/30/18.
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();

        Decorate  decorate = new Decorate2(new Decorate1(new Decorate(person)));

        decorate.walkToWhere();

        decorate.wearCloser();
    }
}
