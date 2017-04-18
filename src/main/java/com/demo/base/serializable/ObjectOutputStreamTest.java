package com.demo.base.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created by yangyuan on 17-4-18.
 *
 * objectoutstream 序列化的对象需要实现serializable接口
 */
public class ObjectOutputStreamTest {

    public static void main(String[] args) throws  Exception{
        File file = new File("/home/yangyuan/test.data");
        OutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new Person());
        objectOutputStream.close();
    }
}
