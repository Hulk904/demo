package com.demo.base.algorithm;

/**
 * Created by yangyuan on 8/27/18.
 */
public class MaxLong {
    public static void main(String[] args) {
        int[] data = new int[]{86,7,8,311};
        sort(data,0,data.length - 1);
        StringBuilder sb = new StringBuilder();
        for(int data1:data){
            sb.append(data1);
        }
        System.out.println(sb.toString());
    }

    public static void sort(int [] data,int lo,int hi){
        if(lo >= hi){
            return ;
        }
        int index = partition(data,lo,hi);
        sort(data,lo,index -1);//分解点的数据不参与下一次的排序，所以是index - 1 和index + 1
        sort(data,index + 1,hi);
    }

    public static int partition(int []data,int lo,int hi){
        int pirot = data[lo];
        while (lo < hi){
            while (!bigger(data[hi] , pirot) && lo < hi){
                hi --;
            }
            data[lo] = data[hi];
            while(bigger(data[lo] , pirot) && lo < hi){
                lo ++;
            }
            data[hi] = data[lo];
        }
        data[lo] = pirot;
        return hi;
    }

    private static boolean bigger(int a, int b ){
        int c = Integer.parseInt(a + "" + b);
        int d = Integer.parseInt(b + "" + a);
        return c >d;
    }


}
