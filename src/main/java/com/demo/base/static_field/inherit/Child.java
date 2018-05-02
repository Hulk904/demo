package com.demo.base.static_field.inherit;

/**
 * Created by yangyuan on 3/15/18.
 */
public class Child extends Parent{
    private Integer i  = 3;
    private char c = 'B';
    private long l;

    public void add(){
        System.out.println("add");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.add();
    }
}
