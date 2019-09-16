package com.demo.base.thread;

/**
 * Created by yangyuan on 2019/9/6.
 *
 * @author yangyuan
 * @date 2019/09/06
 */
public class ThreadNewTest {

    public static void main(String[] args) {
        System.out.println("begin");
        new Thread(()->{
            for (int i = 0 ;i < 1000; i++){
                System.out.println(i);
            }
        }).start();
        System.out.println("end");
    }
}
