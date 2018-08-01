package com.demo.base.object_array;

/**
 * Created by yangyuan on 7/25/18.
 */
public class Test {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Person("yy");
        Object array = persons;
        Object[] t = (Object[])array;
        for (Object temp:t){
            if(temp instanceof Person) {
                System.out.println(temp);
            }
        }
    }
}
