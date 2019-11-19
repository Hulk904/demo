package com.demo.base.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan77 on 2019/10/22.
 */
public class ComparatorSort {
    public static void main(String[] args) {
        List<BaseItem> list = new ArrayList<>();
        Integer[] array =
        {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3};
        for(int a:array){
            list.add(new BaseItem(a));
        }
        Collections.sort(list, (o1, o2) -> {
            if ( o1.getScore() == null) {
                return 1;
            }
            if (o2.getScore() == null) {
                return -1;
            }
            return o2.getScore().compareTo(o1.getScore());
        });
        list.stream().forEach(System.out::println);
//        Integer[] array =
//                {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                        0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3};
    }
}
