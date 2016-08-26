package com.demo.base;

import java.io.UnsupportedEncodingException;

/**
 * Created by yangyuan on 16-5-19.
 */
public class EncodeTest {
    public static void main(String[] args) {
        String name = "I am 君山";
        //toHex(name.toCharArray());
        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            toHex(iso8859);
            byte[] gb2312 = name.getBytes("GB2312");
            toHex(gb2312);
            byte[] gbk = name.getBytes("GBK");
            toHex(gbk);
            byte[] utf16 = name.getBytes("UTF-16");
            toHex(utf16);
            byte[] utf8 = name.getBytes("UTF-8");
            toHex(utf8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    static void toHex(byte [] p){

    }
}
