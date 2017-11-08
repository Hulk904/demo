package com.demo.base.jvm.objectsize;

/**
 * Created by yangyuan on 11/1/17.
 */
public class CodeTest {
    private Integer i = 51;

    public void add (int a, int b ){
        CodeTest test= this;
        int z = a + b;
        int x = 3;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.add(2,3);
    }
}
