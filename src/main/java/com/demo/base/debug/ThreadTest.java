package com.demo.base.debug;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 8/1/18.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(3);
        threadPoolExecutor.execute(new Task());
        threadPoolExecutor.execute(new Task2());
        threadPoolExecutor.shutdown();
        TimeUnit.SECONDS.sleep(1000);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("tttt");
            }
        }
    }

    static class Task2 implements  Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("bbbb");
            }
        }
    }

}
