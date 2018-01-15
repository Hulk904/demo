package com.demo.base.num;

/**
 * Created by yangyuan on 1/9/18.
 */
public class PrecisionTest {
    public static void main(String[] args) {
        int loop = 20;
        float f = 0f;
        for(int i = 0 ;i < loop ;i ++){
            f += 1.0/(1 << (i+ 1));
        }
        System.out.println(f);
    }
}
