package com.demo.base.classloader;

import com.demo.base.serializable.Person;

/**
 * Created by yangyuan on 16-8-23.
 */
public class ClassLoaderInfo {
    public static void main(String[] args) throws Exception{
//        System.out.println(ClassLoaderInfo.class.getClassLoader().toString());
//        ClassLoader.getSystemClassLoader();
//        Class clazz = Person.class;//也会加载 Person但是不会执行static快
//        clazz.getClassLoader();
//        Class clazz1 = ClassLoaderInfo.class.getClassLoader().loadClass(clazz.getName());//这里并不会执行static快
//        Class.forName(clazz.getName(),true,ClassLoaderInfo.class.getClassLoader());//true 则会执行static块
//        System.out.println(clazz == clazz1);//true
          Person person  ;//只是声明不会加载类
    }
}
