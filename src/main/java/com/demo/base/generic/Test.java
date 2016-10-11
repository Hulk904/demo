package com.demo.base.generic;

/**
 * Created by yangyuan on 16-9-30.
 */
public class Test {
    public static void main(String[] args) {
        try {
            say(Integer.class);
        }catch (Exception exc){
            System.out.println(exc);
        }

    }
    public static <T> T say(Class param) throws  Exception{
        System.out.println(param);
        return  (T)param.newInstance();
    }
}
