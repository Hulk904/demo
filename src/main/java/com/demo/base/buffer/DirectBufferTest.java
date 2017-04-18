package com.demo.base.buffer;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * Created by yangyuan on 17-1-18.
 */
public class DirectBufferTest {
    public static void main(String[] args) throws Exception{
        ByteBuffer bf = ByteBuffer.allocateDirect(1024*1024*300);
        System.out.println("start");
        Thread.sleep(2000);
        clean(bf);
        System.out.println("end");
        int [] dd= new int[Integer.MAX_VALUE+1];
        Thread.sleep(2000);
    }

    public static void clean(final ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            ((DirectBuffer)byteBuffer).cleaner().clean();
        }
    }
}
