package com.demo.proxydemo;

/**
 * Created by yangyuan on 16-5-17.
 */
public class RealSubject implements Subject{
    @Override
    public String visit() {
        return "I am 'RealSubjnec',I am the execution method";
    }
}
