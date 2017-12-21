package com.demo.base;

/**
 * Created by yangyuan on 12/18/17.
 */
public class FinallyByteCodeTest {

    public static void main(String[] args) {
        System.out.println(new FinallyByteCodeTest().test());
        System.out.println(a);
    }
    static int a = 1;
    int test(){
        try{
            return func1();
        }finally {
            return func2();
        }
    }
    int func1(){
        System.out.println("func1");
        a = 3;
        return 1;
    }
    int func2(){
        System.out.println("func2");
        a = 5;
        return 2;
    }
}
