package com.demo.base.algorithm.consumerandprovider;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuan on 1/12/18.
 */
public class BaseLockImpl<T> implements BlockingQueue<T>{

    private Object[] data;

    private int capacity ;

    private int tflag=0, pflag =0,count = 0;//consumerCount;

    private Lock lock = new ReentrantLock();

    private Condition  notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    public BaseLockImpl(int capacity){
        this.capacity = capacity;
        data = new Object[capacity];
    }

    @Override
    public void put(T t)  throws InterruptedException{
        lock.lock();
        try {
            while(count == capacity) {//满
                notFull.await();
            }
            data[pflag] = t;
            if(++ pflag == capacity){
                pflag = 0;
            }
            ++count  ;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }

    }

    @Override
    public T take() throws InterruptedException{
        lock.lock();
        try{
            while(count == 0) {//todo 为啥用while正确，用if错误呢？  存在虚假唤醒，虚假唤醒也会引起当前线程唤醒，所以用while
                notEmpty.await();
            }
            T result = (T)data[tflag];
            if(++ tflag == capacity){
                tflag = 0;
            }
            --count ;
            notFull.signal();
            if(result == null){
                System.out.println("for stop");
            }
            return result;
        }finally {
            lock.unlock();
        }

    }
}
