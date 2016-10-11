package com.demo.base.thread.threadlocal;

/**
 * Created by yangyuan on 16-9-21.
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> integerThreadLocal = new ThreadLocal<String>();
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>();


    public static void main(String[] args) throws  Exception{
        for(int i = 0 ;i <100 ;i ++){
            final String name = "线程-【" + i + "】";
            final String value =  String.valueOf(i);
            new Thread() {
                public void run() {
                    try {
                        integerThreadLocal.set(name);
                        stringThreadLocal.set(value);
                        callA();
                    }catch (Exception exc){

                    }
//                 finally {
//                        integerThreadLocal.remove();
//                        stringThreadLocal.remove();
//                    }
                }
            }.start();
            Thread.sleep(3000);
        }
    }

    public static void callA() {
        callB();
    }

    public static void callB() {
        new ThreadLocalTest().callC();
    }

    public void callC() {
        callD();
    }

    public void callD() {
        System.out.println(integerThreadLocal.get() + "/t=/t" + stringThreadLocal.get());
    }
}
