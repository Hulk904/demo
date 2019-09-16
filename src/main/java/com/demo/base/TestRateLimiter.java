package com.demo.base;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by yangyuan on 2019/9/10.
 *
 * @author yangyuan
 * @date 2019/09/10
 */
public class TestRateLimiter {


    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(15, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("zzzzzzzzz ------ " + i);
            currentTimeMillis = System.currentTimeMillis();
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
