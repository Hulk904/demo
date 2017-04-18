package com.demo.base.juc.aqs;


import java.util.concurrent.locks.Lock;

/**
 * Created by yangyuan on 17-2-8.
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            public void run(){
                while (true){
                    lock.lock();
                    try{
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }catch (Exception exc){
                        System.out.println(exc);
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i = 0 ;i < 10 ;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for(int i = 0 ;i < 20 ; i++ ){
            try {
                Thread.sleep(1000);
                System.out.println();
            }catch (Exception exc){
                System.out.println(exc);
            }

        }
    }
}
