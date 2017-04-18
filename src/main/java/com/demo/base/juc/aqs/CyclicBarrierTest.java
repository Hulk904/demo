package com.demo.base.juc.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
  Created by yangyuan on 17-3-1.
 */
public class CyclicBarrierTest {
    private static final int THREAD_NUM = 5;

    public static class WorkerThread implements Runnable{

        CyclicBarrier barrier;

        public WorkerThread(CyclicBarrier b){
            this.barrier = b;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try{
                System.out.println("Worker's waiting");
                //线程在这里等待，直到所有线程都到达barrier。
                barrier.await();
                System.out.println("ID:"+Thread.currentThread().getId()+" Working");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable() {
            //当所有线程到达barrier时执行
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("Inside Barrier");
                try {
                    Thread.sleep(1000);
                }catch (Exception exc){

                }


            }
        });

//        for(int i=0;i<THREAD_NUM;i++){
//            new Thread(new WorkerThread(cb)).start();
//        }

        List<Thread> threads = new ArrayList<Thread>(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            Thread thread = new Thread(new WorkerThread(cb));
            threads.add(thread);
            thread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println("hihihi");
    }
}

