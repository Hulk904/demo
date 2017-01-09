package com.demo.base.thread;

/**
 * Created by yangyuan on 16-10-21.
 */
public class ThreadClassLoader {
    public static void main(String[] args) {
        System.out.println(ThreadClassLoader.class.getClassLoader().toString());
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getContextClassLoader().toString());

    }
}
