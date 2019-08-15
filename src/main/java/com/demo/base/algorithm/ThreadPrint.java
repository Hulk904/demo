package com.demo.base.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyuan on 2019/3/21.
 *
 * @author yangyuan
 * @date 2019/03/21
 */
public class ThreadPrint {
    public static AtomicInteger num = new AtomicInteger(1);
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SimpleThread(1));
        Thread thread2 = new Thread(new SimpleThread(0));
        thread2.start();
        thread1.start();
    }
    static class SimpleThread implements Runnable{
        private int v;
        public SimpleThread(int v){
            this.v = v;
        }
        @Override
        public void run(){
            while (num.get() <= 100) {
                if (num.get() % 2 == v && num.get() <= 100){
                    System.out.println(Thread.currentThread().getName() + "   " + num.get());
                    num.incrementAndGet();
                }
            }
        }
    }
}
