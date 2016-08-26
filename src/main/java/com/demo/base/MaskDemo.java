package com.demo.base;

/**
 * Created by yangyuan on 16-6-3.
 */
public class MaskDemo {
    public static final int ALLOW_SELECT = 1 << 0; // 0001

    // 是否允许新增，二进制第2位，0表示否，1表示是
    public static final int ALLOW_INSERT = 1 << 1; // 0010

    // 是否允许修改，二进制第3位，0表示否，1表示是
    public static final int ALLOW_UPDATE = 1 << 2; // 0100

    // 是否允许删除，二进制第4位，0表示否，1表示是
    public static final int ALLOW_DELETE = 1 << 3; // 1000


    public static void main(String args[]) {

        System.out.println(MaskDemo.contains(ALLOW_SELECT ,ALLOW_SELECT));
        System.out.println(MaskDemo.contains(ALLOW_SELECT|ALLOW_UPDATE , ALLOW_SELECT));
        System.out.println(MaskDemo.contains(ALLOW_INSERT|ALLOW_UPDATE , ALLOW_SELECT));
        System.out.println(MaskDemo.contains(ALLOW_UPDATE , ALLOW_SELECT));
        System.out.println(MaskDemo.contains(ALLOW_DELETE , ALLOW_SELECT));

    }

    public static boolean contains(int num ,int permission) {
        return (num & permission) != 0;
    }
}
