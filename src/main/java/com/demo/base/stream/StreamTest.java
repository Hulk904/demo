package com.demo.base.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 17-3-27.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.stream().findFirst());
    }
}
