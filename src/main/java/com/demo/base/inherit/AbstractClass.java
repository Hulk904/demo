package com.demo.base.inherit;

/**
 * Created by yangyuan on 8/19/17.
 */
public abstract class AbstractClass {
    private String name = "abstract";

    public void sayHello(){
        System.out.println(name + "hello.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
