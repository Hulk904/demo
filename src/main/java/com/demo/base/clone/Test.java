package com.demo.base.clone;

/**
 * Created by yangyuan on 4/16/18.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Person p = new Person("上三",12);
        Person p2 =(Person) p.clone();
        System.out.println(p2);
    }
}
