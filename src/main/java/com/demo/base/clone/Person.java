package com.demo.base.clone;

/**
 * Created by yangyuan on 4/16/18.
 */
public class Person implements Cloneable{

    private String name ;

    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
