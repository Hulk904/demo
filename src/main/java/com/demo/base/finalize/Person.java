package com.demo.base.finalize;

/**
 * Created by yangyuan on 7/24/18.
 */
public class Person {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public void finalize(){
        System.out.println("被回收了。");
    }
}
