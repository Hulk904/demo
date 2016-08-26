package com.demo.base.thread;

import org.apache.http.impl.conn.SystemDefaultDnsResolver;

/**
 * Created by yangyuan on 16-6-30.
 */
public class VolitileTest {
    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread thread1  = new Thread1(example);
        Thread thread2  = new Thread2(example);
        thread1.start();
        thread2.start();
    }
}

class VolatileExample{
    int  a = 0 ;
    volatile   boolean flag = true;

    public void writer(){
//        try {
//            Thread.sleep(1000);
//        }catch (Exception exc){
//
//        }
        System.out.println("writer");
        a =1;
        flag = true;

    }

    public void reader(){
        if(flag){
            int i =a ;
            System.out.println("read i= "+i);
        }
    }
}
class Thread1 extends  Thread{
    private VolatileExample example;
    public Thread1(VolatileExample example){
        this.example = example;
    }
    public void run (){
        example.writer();
    }
}
class  Thread2 extends  Thread{
    private VolatileExample example;
    public Thread2(VolatileExample example){
        this.example = example;
    }
    public void  run(){
        example.reader();
    }
}