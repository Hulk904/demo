package com.demo.base.date;

import java.time.LocalDate;

/**
 * Created by yangyuan on 5/24/18.
 */
public class LocalDateTest {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.atStartOfDay());
        System.out.println(localDate.plusDays(1l));
    }
}
