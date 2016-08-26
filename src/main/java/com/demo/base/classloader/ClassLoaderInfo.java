package com.demo.base.classloader;

/**
 * Created by yangyuan on 16-8-23.
 */
public class ClassLoaderInfo {
    public static void main(String[] args) {
        System.out.println(ClassLoaderInfo.class.getClassLoader().toString());
        ClassLoader.getSystemClassLoader();
    }
}
