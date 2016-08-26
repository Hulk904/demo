package com.demo.base.thread.wait_notify;

/**
 * Created by yangyuan on 16-7-13.
 */
public class ThreadF {
    public static void main(String[] args) {
        final Object object = new Object();
        Thread t1 = new Thread() {
            public void run()
            {
                synchronized (object) {
                    System.out.println("T1 start!");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1 end!");
                }
            }
        };
        Thread t2 = new Thread() {
            public void run()
            {
                synchronized (object) {
                    System.out.println("T2 start!");
                    object.notify();
                    System.out.println("T2 end!");
                }
            }
        };
        t2.start();
        t1.start();

    }
}
