package com.demo.base.algorithm.sort;

import java.util.Arrays;

/**
 * Created by yangyuan on 1/12/18.
 * 数组组合最大数
 * 本质就是定义两个数据的大小排序规则
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{21,3,45,33,56,33,78,5,4,3,109,42};
        sort(data,0,data.length - 1);
        System.out.println(Arrays.toString(data));
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
            while (data[hi] >= pirot && lo < hi){
                hi --;
            }
            data[lo] = data[hi];
            while(data[lo] <= pirot && lo < hi){
                lo ++;
            }
            data[hi] = data[lo];
        }
        data[lo] = pirot;
        return hi;
    }

//    private static void qsort(int[] arr, int low, int high){
//        if (low < high){
//            int pivot=partition(arr, low, high);        //将数组分为两部分
//            qsort(arr, low, pivot-1);                   //递归排序左子数组
//            qsort(arr, pivot+1, high);                  //递归排序右子数组
//        }
//    }
//    private static int partition(int[] arr, int low, int high){
//        int pivot = arr[low];     //枢轴记录
//        while (low<high){
//            while (low<high && arr[high]>=pivot) --high;
//            arr[low]=arr[high];             //交换比枢轴小的记录到左端
//            while (low<high && arr[low]<=pivot) ++low;
//            arr[high] = arr[low];           //交换比枢轴小的记录到右端
//        }
//        //扫描完成，枢轴到位
//        arr[low] = pivot;
//        //返回的是枢轴的位置
//        return low;
//    }

}
