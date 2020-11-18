package com.demo.base.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 1/12/18.
 * 数组组合最大数
 * 本质就是定义两个数据的大小排序规则
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = new int[]{21,3,45,33,56,33,78,5,4,3,109,42};
        //sort(data,0,data.length - 1);
        //System.out.println(Arrays.toString(data));
        //QuickSort q = new QuickSort();
        //q.quickSort(data, 0, data.length - 1);
        //System.out.println(Arrays.toString(data));
        QuickSort quickSort = new QuickSort();
        int [] next = quickSort.next("abcab");
        System.out.println(Arrays.toString(next));
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int partion = partion(nums, left, right);
        quickSort(nums, left, partion - 1);
        quickSort(nums, partion + 1, right);
    }

    int partion (int[] nums, int left, int right){
        int pirot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pirot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pirot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pirot;
        return left;
    }

    public static void sort(int [] data,int lo,int hi){
        if(lo >= hi){
            return ;
        }
        int index = partition(data,lo,hi);
        sort(data,lo,index -1);//分界点的数据不参与下一次的排序，所以是index - 1 和index + 1
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

    List<Integer> kmp(String s, String p){
        int[] next = next(p);
        List<Integer> res =  new ArrayList<>();
        for (int i = 0, j = -1; i < s.length(); i++){
            while (j >=0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == p.charAt(j + 1)){
                j++;
            }
            if (j == p.length() - 1){
                res.add(i - j);
                j = next[j];//容易漏掉
            }
        }
        return res;
    }

    private int[] next(String t){
        int[] next = new int[t.length()];
        Arrays.fill(next, -1);
        for (int i = 1, j = -1; i < t.length(); i++){
            while (j >= 0 && t.charAt(i) != t.charAt(j + 1)) j = next[j];
            if (t.charAt(i) == t.charAt(j + 1)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
