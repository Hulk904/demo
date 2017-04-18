package com.demo.base.dispatcher;

/**
 * Created by yangyuan on 17-3-8.
 */
public class DynamicDispatch {
    static  abstract  class Human {
        protected abstract void sayHello();
    }
        static class Man extends Human{
            protected void sayHello(){
                System.out.println("man say hello");
            }
        }

        static class Women extends Human{
            protected void sayHello(){
                System.out.println("women say hello");
            }
        }

    public static void main(String[] args) {
        Man man = new Man();
        Women women = new Women();
        man.sayHello();
        women.sayHello();
    }

}
