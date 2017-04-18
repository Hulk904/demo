package com.demo.base.buffer;

import java.nio.ByteBuffer;

/**
 * Created by yangyuan on 17-2-8.
 */
public class DirectBufferFull {
    public static void main(String[] args)throws Exception{
        System.out.println("start");
        for(int i = 0 ;i < 10;i ++){
            ByteBuffer.allocateDirect(1024*1024*800);
        }
        Thread.sleep(20000);
        System.out.println("end");
    }
}
