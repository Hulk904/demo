package com.demo.base.thread.easy;

/**
 * Created by yangyuan on 17-1-9.
 */
public class ServerStart {
    public static void main(String[] args) {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        try {
            simpleHttpServer.start();
        }catch (Exception exc){
            System.out.println(exc);
        }
    }
}
