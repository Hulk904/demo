package com.demo.base.thread.threadlocal;

/**
 * Created by yangyuan on 17-1-6.
 */
public class TestParam {

    public  static ThreadLocal<String> param = new InheritableThreadLocal<String>();
    public static void main(String[] args) {
        param.set("1234");
//        TestBean testBean = new TestBean();
//        testBean.say();
        System.out.println(param.get());
        new Thread( ){public void run() {
            System.out.println(param.get());
        }}.start();
    }
}
