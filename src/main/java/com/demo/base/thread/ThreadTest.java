package com.demo.base.thread;

/**
 * Created by yangyuan on 17-3-2.
 */
public class ThreadTest {
    public static void main(String[] args) throws  Exception{
        Thread thread = new Thread(new Worker("aaa"));
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isAlive());
    }
}
class Worker implements Runnable{
    String s ="";
    public Worker(String s){
        this.s = s ;
    }
    @Override
    public void run() {
        System.out.println("hi : "+ s);
    }
}
