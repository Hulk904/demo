package com.demo.base.reflect;

import com.demo.thrift.support.impl.Man;

import java.lang.reflect.Method;

/**
 * Created by yangyuan on 16-6-14.
 */
public class ReflectTest {
    public static void main(String[] args) {
        Man  man = new Man();
        Method[] methods = man.getClass().getDeclaredMethods();
        int b = 0;
        System.out.println(int.class );
        try {
            methods[1].invoke(man, null);//private方法不能调用
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
