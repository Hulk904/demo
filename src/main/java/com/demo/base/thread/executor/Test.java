package com.demo.base.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yangyuan on 16-9-8.
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor excutor =(ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        try{
            excutor.execute(new TaskUnit());
        }catch (Exception exc){

        }finally {
            excutor.shutdown();
        }

        System.out.println("main out");
    }
}
