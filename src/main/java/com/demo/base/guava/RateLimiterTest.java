package com.demo.base.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;

/**
 * Created by yangyuan on 17-2-22.
 */
public class RateLimiterTest {
//    final static RateLimiter rateLimiter = RateLimiter.create(5);
//    public static void main(String[] args) {
//        for (int i = 9 ;i <100;i++) {
//            MyThread myThread = new MyThread(rateLimiter,i);
//            myThread.start();
//        }
//
//    }
//
//}
//class  MyThread extends Thread{
//    RateLimiter rateLimiter;
//    public MyThread(RateLimiter rateLimiter,int i){
//        super(i+"");
//        this.rateLimiter = rateLimiter;
//    }
//    @Override
//    public void run() {
//        rateLimiter.acquire();
//        System.out.println(Thread.currentThread().getName()+new Date());
//    }
    public static void main(String[] args) {
    final  RateLimiter rateLimiter = RateLimiter.create(5);
    Thread thread = new MyThread(rateLimiter);
    thread.start();
    }
    static class  MyThread extends Thread {
        RateLimiter rateLimiter;

        public MyThread(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
        }

        @Override
        public void run() {
            for(int i = 0 ;i<100 ;i++) {
                rateLimiter.acquire();
                System.out.println(Thread.currentThread().getName() + new Date());
            }
        }
    }
}
