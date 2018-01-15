package com.demo.base.algorithm.consumerandprovider;

/**
 * Created by yangyuan on 1/12/18.
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new BaseLockImpl<>(10);
        Thread producer = new Thread(new Provider(queue));
        producer.start();
        Thread consumer = new Thread(new Consumer(queue));
        consumer.start();
        Thread consumer2 = new Thread(new Consumer(queue));
        consumer2.start();

    }
}
