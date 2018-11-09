package com.demo.base.lock;

import java.util.concurrent.TimeUnit;

public class TestSync {
    private Object o = new Object();

    private void method1() throws InterruptedException {
        Object o1 = o;
        synchronized (o1){
            System.out.println("111111111111");
            TimeUnit.SECONDS.sleep(5);
        }
    }

    private void  method2() throws InterruptedException {
        Object o2 = o;
        synchronized (o2){
            System.out.println("2222222222222");
            TimeUnit.SECONDS.sleep(10);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync testSync = new TestSync();
        new Thread(() ->{
            try {
                testSync.method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                testSync.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
