package com.demo.base.dispatcher;

/**
 * Created by yangyuan on 17-3-8.
 */
public class StaticDispatch {

    static abstract class Human {

    }

    static class Man extends  Human{

    }

    static class Women extends Human{

    }

    public  void sayHello(Human guy){
        System.out.println("hi human ");
    }

    public void sayHello(Women women){
        System.out.println("hi women");
    }

    public void sayHello(Man man){
        System.out.println("hi man");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Women();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
    }

}
