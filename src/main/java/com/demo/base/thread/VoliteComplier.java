package com.demo.base.thread;

/**
 * Created by yangyuan on 16-12-26.
 */
public class VoliteComplier {
    static volatile int b = 2;
    public static void main(String[] args) {
         b = 4;
    }
}
