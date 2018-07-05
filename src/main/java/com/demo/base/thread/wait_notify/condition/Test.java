package com.demo.base.thread.wait_notify.condition;

import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 7/5/18.
 */
public class Test {
    public static void main(String[] args) {
        final ConditionUserCase conditionUserCase = new ConditionUserCase();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionUserCase.conditionWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }});




        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                conditionUserCase.conditionSignal();
            }
        });

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }
}
