package com.demo.base.finalize;


/**
 * Created by yangyuan on 7/24/18.
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("yy");
        person = null;
        System.gc();
        System.out.println("end");
    }
}
