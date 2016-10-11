package com.demo.base.innerclass;

/**
 * Created by yangyuan on 16-9-6.
 */
public class TestDemo {
    private String name = "he";

    class InnerClass{
        private int age = 2;
        public void getMessage(){
            System.out.println(age + name);
        }


    }
}
