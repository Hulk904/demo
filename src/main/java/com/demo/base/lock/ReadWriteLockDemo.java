package com.demo.base.lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yangyuan
 * @date 2020-11-18.
 * 读写锁和重入锁 在读多写少场景下的测试。
 * 200 （195读， 5写） 重入锁 200 秒多， 读写锁 6秒多 。  差距还是很大的
 * 主要时读写锁，读是可以并发执行的。而重入锁 是同步关系，只能一个一个执行
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    private CountDownLatch countDownLatch;

    public ReadWriteLockDemo (CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    public Object handleRead(Lock lock) throws InterruptedException{
        try {
            lock.lock();
            //模拟读操作
            Thread.sleep(1000);
            countDownLatch.countDown();
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws InterruptedException{
        try {
            lock.lock();
            Thread.sleep(1000);
            countDownLatch.countDown();
            value = index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(200);
        ReadWriteLockDemo demo = new ReadWriteLockDemo(countDownLatch);
        long t1 = System.currentTimeMillis();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);//替换为lock 体验 耗时情况
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 195; i++) {
            new Thread(readRunnable).start();
        }
        for (int i = 195; i < 200; i++) {
            new Thread(writeRunnable).start();
        }
        countDownLatch.await();
        System.out.println((System.currentTimeMillis() - t1));
    }


}

