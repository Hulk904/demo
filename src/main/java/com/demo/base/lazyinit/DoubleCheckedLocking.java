package com.demo.base.lazyinit;

/**
 * Created by yangyuan on 1/15/18.
 */
public class DoubleCheckedLocking {

    private volatile static  Instance instance;

    public static Instance getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLocking.class){
                if(instance == null){
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

    private static class Instance{

    }

}
