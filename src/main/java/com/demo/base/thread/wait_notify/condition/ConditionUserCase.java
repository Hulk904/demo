package com.demo.base.thread.wait_notify.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuan on 7/5/18.
 */
public class ConditionUserCase {
    Lock lock = new ReentrantLock();
    Condition conditon = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "wait" );
            conditon.await();
            System.out.println(Thread.currentThread().getName() + "wait end");
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "signal===");
            TimeUnit.SECONDS.sleep(2);
            conditon.signal();
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
