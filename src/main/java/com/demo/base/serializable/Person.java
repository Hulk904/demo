package com.demo.base.serializable;

import java.io.Serializable;

/**
 * Created by yangyuan on 17-4-18.
 */
public class Person implements Serializable {
    static {
        System.out.println("i'm static!");
    }
    private String name;
    private int age;
    public Person(){}

    public Person(int age ,String name){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}