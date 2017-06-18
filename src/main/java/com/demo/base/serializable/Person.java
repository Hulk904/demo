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
}
