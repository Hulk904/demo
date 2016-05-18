package com.demo.thrift.support.impl;

import com.demo.thrift.support.PersonTest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangyuan on 16-4-29.
 */
public class Man {
    @Transactional
    public void test(){
        System.out.println("123");
    }
}
