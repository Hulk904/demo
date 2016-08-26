package com.demo.base;

/**
 * Created by yangyuan on 16-8-9.
 */
public class TryCatch {
    public static void main(String[] args) {

        System.out.println(fun(3));
    }
    public static  int fun(int b){
        try{
            if(true)
            throw new RuntimeException();
            return b+4;
        }catch (Exception exc){

        }finally {
            b = 10;
        }
        System.out.println(b);
        return b;
    }
}
