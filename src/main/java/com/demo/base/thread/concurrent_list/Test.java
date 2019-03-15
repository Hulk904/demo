package com.demo.base.thread.concurrent_list;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Created by yangyuan on 2019/2/1.
 *
 * @author yangyuan
 * @date 2019/02/01
 */
public class Test {
    private static List<String> list = Lists.newArrayList();

    public static void main(String[] args) {
        list.add("123");
        list.add("33");
        list.add("444");
        list.add("123");
        list.add("33");
        list.add("444");
        list.add("123");
        list.add("33");
        list.add("444");


        new Thread(() ->{
            for (String s: list){
                System.out.println(s);
            }
            Collections.sort(list);
        }).start();

        new Thread(() ->{
            for (String s: list){
                System.out.println(s);
            }
            Collections.sort(list);
        }).start();

    }
}
