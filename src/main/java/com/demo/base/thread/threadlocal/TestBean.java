package com.demo.base.thread.threadlocal;

/**
 * Created by yangyuan on 17-1-6.
 */
public class TestBean {
    public void say(){
        System.out.println("from threadLocal"+TestParam.param.get());
    }
}
