package com.demo.base.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 对线程内异常的处理
 * Created by yangyuan on 2/12/18.
 */
public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread2());
        //设置默认的未捕获异常处理器
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughttExceptionHandler());
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by " + t);
        System.out.println("eh = " +  t.getUncaughtExceptionHandler());
        throw new RuntimeException("====error ==");
    }
}

class MyUncaughttExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("cautht " +  e) ;
    }
}

class  HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("create " + r);
        t.setUncaughtExceptionHandler(new MyUncaughttExceptionHandler());
        System.out.println("eh =" + t.getUncaughtExceptionHandler());
        return t;

    }
}
