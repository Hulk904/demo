package com.demo.base.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by yangyuan on 2019/8/15.
 * 异步线程提交的任务，如果超时了
 * 1、任务本身响应中断，比如sleep 方法 这时候异步任务会结束
 * 2、任务不响应中断，则任务不会结束，在后台继续运行。而Future 会 抛出timeout的异常
 * @author yangyuan
 * @date 2019/08/15
 */
public class FutrureInterrupt {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask =
            new FutureTask<String>(new Callable<String>() {//使用Callable接口作为构造参数
                @Override
                public String call() {
                    for (long i = 0; i < Long.MAX_VALUE; i++) {
                       Math.sqrt(i);
                    }
                    //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                    return "call result";
                }});
        executor.execute(futureTask);
        //在这里可以做别的任何事情
        try {
            String result = futureTask.get(3000, TimeUnit.MILLISECONDS);
            //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
            System.out.println("___________"+result+"_______________");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException222222");
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            System.out.println("InterruptedException333333333");
            futureTask.cancel(true);
        } catch (TimeoutException e) {
            System.out.println("!!!!!!!!Time out!!!!!!!!!!");
            futureTask.cancel(true);
        } finally {
            executor.shutdown();
        }
    }
}

