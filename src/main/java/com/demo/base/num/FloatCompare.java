package com.demo.base.num;

/**
 * Created by yangyuan on 1/4/18.
 */
public class FloatCompare {
    public static void main(String[] args) {
        float a = -0.0f;
        float b = 0.0f;
        System.out.println(a == b);//true
        System.out.println(Float.compare(a, b));//-1
        Float c = -0.0f;
        Float d = 0.0f;
        System.out.println(c.compareTo(d));
    }
}
