package com.demo.base.stream;

import java.util.HashMap;
import java.util.Map;
//import java.util.stream.Collectors;

/**
 * Created by yangyuan on 17-4-12.
 */
public class MapStreamTest {
    public static void main(String[] args) {
        Map<String,String> temp  = new HashMap<>();
        temp.put("111","aaa");
        temp.put("222","bbb");
        temp.put("333","ccc");
        temp.put("444","ddd");
        temp.put("555","eee");
      //  temp.entrySet().stream().filter(b -> b.getKey() == "444" || b.getKey() == "555").collect(Collectors.toMap());

    }
}
