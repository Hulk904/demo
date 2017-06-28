package com.demo.base.thread.threadlocal.inheritable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 6/28/17.
 */
public class Test {
    public static void main(String[] args) throws Exception{


        final InheritableThreadLocal<Span> inheritableThreadLocal = new InheritableThreadLocal<Span>();
        inheritableThreadLocal.set(new Span("xiexiexie"));
        //输出 xiexiexie
        System.out.println(inheritableThreadLocal.get());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("========");
                System.out.println(inheritableThreadLocal.get());
                inheritableThreadLocal.set(new Span("zhangzhangzhang"));
                System.out.println(inheritableThreadLocal.get());
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(runnable);
        TimeUnit.SECONDS.sleep(1);
        executorService.submit(runnable);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("========");
        System.out.println(inheritableThreadLocal.get());
    }
    static class Span {
        public String name;
        public int age;
        public Span(String name) {
            this.name = name;
        }
        public String toString(){
            return name;
        }
    }
}


