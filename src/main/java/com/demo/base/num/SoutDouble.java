package com.demo.base.num;

import java.math.BigDecimal;

/**
 * Created by yangyuan on 16-10-28.
 */
public class SoutDouble {
    public static void main(String[] args) {
//        float i = 0.2f;
//        double j =i;
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(i == j);
        BigDecimal b = new BigDecimal(0.0d);
        System.out.println(b.doubleValue() == 0);

    }
}
