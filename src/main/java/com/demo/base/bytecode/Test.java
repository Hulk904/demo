package com.demo.base.bytecode;

/**
 * Created by yangyuan on 4/9/18.
 */
public class Test {
    public int add(int a, int b){
        Test test = this;
        int z = a + b ;
        return z;
    }

    public static void main(String[] args) {
        Test  test = new Test();
        test.add(4,8);
    }
}
