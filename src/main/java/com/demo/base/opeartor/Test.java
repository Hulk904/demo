package com.demo.base.opeartor;

/**
 * Created by yangyuan on 2019/1/11.
 *
 * @author yangyuan
 * @date 2019/01/11
 */
public class Test {
    public static void main(String[] args) {
        int i = 2;
        int j =3;
        System.out.println(i != (i = j));//true  看字节码指令
    }
}
