package com.demo.base.algorithm.consumerandprovider;

/**
 * Created by yangyuan on 1/12/18.
 */
public class Provider implements Runnable{
    private BlockingQueue<String> blockingQueue;
    public Provider(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        for(int i = 0;i< 20 ;i ++){
            try {
                Thread.sleep(1000);
                blockingQueue.put("i am" + i  );
            }catch (Exception exc){
                System.out.println(exc);
            }
        }
    }
}
