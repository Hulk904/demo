package com.demo.base.thread.excep;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by yangyuan on 2019/2/27.
 * 异常会导致当前线程结束被回收
 * 但是线程池中的线程还是相互没有影响的
 * @author yangyuan
 * @date 2019/02/27
 */
public class Test {
    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        for(int i = 0; i<10; i++) {
            executor.execute(() -> {
                long t = System.currentTimeMillis() % 3;
                System.out.println(Thread.currentThread().getName() + "   " +t);
                if( t == 0){
                    throw new RuntimeException("eeero");
                }
            });
        }
        executor.shutdown();
    }

}
