package com.demo.base.reflect;

/**
 * Created by yangyuan on 17-2-21.
 * no  set and get methods
 */
public class User {

    private String name = "test";
    private long id = 1;
    private int age = 2;
    private double height = 1.72;


    @Override
    public String toString() {
        return name + "," + id + "," + age + "," + height;
    }
}
