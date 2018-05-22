package com.demo.base.null_check;


import javax.validation.Valid;

/**
 * Created by yangyuan on 5/17/18.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        print(person);
    }
    private static void  print(@Valid Person person){
        System.out.println(person);
    }
}
