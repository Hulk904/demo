package com.demo.base.serializable;

import java.io.Serializable;

/**
 * Created by yangyuan on 17-4-18.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    static {
        System.out.println("i'm static!");
    }
    private String name = "default";
    private int age = -1;

    private Person(){}

//    public Person(int age ,String name){
//        this.age = age;
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
