package com.demo.base.serializable;

import java.io.*;

/**
 * Created by yangyuan on 17-4-18.
 *
 * objectoutstream 序列化的对象需要实现serializable接口
 */
public class ObjectOutputStreamTest {

    public static void main(String[] args) throws  Exception{
        File file = new File("/home/yangyuan/test.data");
//        OutputStream outputStream = new FileOutputStream(file);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(new Person());
//        objectOutputStream.close();
        //反序列化只有private构造函数的对象Person
        InputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person person = (Person)objectInputStream.readObject();
        System.out.println(person.getName());
    }
}
