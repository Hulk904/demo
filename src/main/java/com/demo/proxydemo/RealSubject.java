package com.demo.proxydemo;

/**
 * Created by yangyuan on 16-5-17.
 */
public class RealSubject implements Subject{
    @Override
    public void visit() {
        System.out.println("I am 'RealSubject',I am the execution method");
    }
}
