package com.demo.base.reflect.without_set;

/**
 * Created by yangyuan on 5/15/18.
 */
public class JavaBean {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
