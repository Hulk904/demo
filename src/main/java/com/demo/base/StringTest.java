package com.demo.base;

/**
 * Created by yangyuan on 17-1-20.
 */
public class StringTest {
    public static final  String b = "b1" ;
    public static final  int   bb = 1 ;
    public static void main(String[] args) throws Exception
    {
        String b1 = "b" + bb ;
        System.out.println(b == b1);
        int    b3 = 1 ;
        String b4 = "b" + b3 ;
        System.out.println(b == b4);
        System.out.println(b4.getClass().getClassLoader());
    }
}
