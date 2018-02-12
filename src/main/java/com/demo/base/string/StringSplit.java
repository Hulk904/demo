package com.demo.base.string;

/**
 * Created by yangyuan on 1/30/18.
 */
public class StringSplit {
    public static void main(String[] args) {
        String a = "553248634855575443|Pedraforca|Pedraforca, Saldes, Spain|42.238888|1.706389|";
        String[] as = a.split("[|]");// 最后一个| ，如果后面没数据，不计长度
        System.out.println(as.length);//输出   5
        for(String temp:as){
            System.out.println(temp);
        }
    }
}
