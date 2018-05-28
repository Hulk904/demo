package com.demo.base.lambda.how_implement;

/**
 * Created by yangyuan on 5/28/18.
 */
public class Test {
    public static void main(String[] args) {
        print("yangyuan",(x) -> System.out.println("hello " + x));
    }

    public static void print(String var, FunctionTest functionTest){
        functionTest.sayHello(var);
    }
}
