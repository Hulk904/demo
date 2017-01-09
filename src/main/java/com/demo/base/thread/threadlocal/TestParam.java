package com.demo.base.thread.threadlocal;

/**
 * Created by yangyuan on 17-1-6.
 */
public class TestParam {

    public  static ThreadLocal<String> param = new ThreadLocal<String>();
    public static void main(String[] args) {
        param.set("1234");
        TestBean testBean = new TestBean();
        testBean.say();
    }
}
