package com.demo.base.static_field;

/**
 * Created by yangyuan on 3/15/18.
 */
public class FieldInherit {
    public static void main(String[] args) {
        Man man = new Man();
        man.msg = "man";
        System.out.println(Human.msg);
        Women women = new Women();
        women.msg = "women";
        System.out.println(Human.msg);
    }
}
