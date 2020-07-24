package com.demo.base.intrument;

/**
 * @author yangyuan
 * @date 20-7-23.
 */
public class MyAgentTest {

    public static void main( String[] args ) throws InterruptedException {
        while (true) {
            hello();
            Thread.sleep(1000);
        }
    }

    public static void hello() {
        System.out.println("Hello World!");
    }
}
