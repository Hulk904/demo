package com.demo.base.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangyuan on 2/12/18.
 */
public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException("err");
    }

//    public static void main(String[] args) {//异常可以被抛出并打印出来
//        ExecutorService exe  = Executors.newCachedThreadPool();
//        exe.execute(new ExceptionThread());
//    }
//    public static void main(String[] args) {
//        try {//异常并不能被捕获
//            ExecutorService exe  = Executors.newCachedThreadPool();
//            exe.execute(new ExceptionThread());
//        }catch (Exception exc){
//            System.out.println("new error" + exc);
//        }
//    }
//    public static void main(String[] args) {
//        new Thread(new ExceptionThread()).start();//异常信息还是会被打印的，并不会吞掉异常
//    }
}
