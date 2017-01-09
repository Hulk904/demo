package com.demo.base.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 16-11-12.
 */
public class ArraysTest {
    public static void main(String[] args) {
        String s = "adb;";
        List list = Arrays.asList(s.split(";"));
        System.out.println(list.size());
    }
}
