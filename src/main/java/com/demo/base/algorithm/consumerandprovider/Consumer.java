package com.demo.base.algorithm.consumerandprovider;



/**
 * Created by yangyuan on 1/12/18.
 */
public class Consumer implements Runnable{

    private BlockingQueue<String> blockingQueue ;

    public Consumer(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        for(int i = 0 ;i < 10 ; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "====>" +blockingQueue.take());
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
}
