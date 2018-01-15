package com.demo.base.algorithm.consumerandprovider;

/**
 * Created by yangyuan on 1/12/18.
 */
public interface BlockingQueue <T>{
    void put(T data) throws InterruptedException;
    T take() throws InterruptedException;
}
