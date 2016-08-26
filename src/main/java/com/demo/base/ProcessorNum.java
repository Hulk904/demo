package com.demo.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 16-6-28.
 */
public class ProcessorNum {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Map<String,String > map  = new HashMap<String, String>();
        map.put("12","wwww");
        map.put(null,null);
        map.remove("2");
        System.out.println(System.getProperty("line.separator")+"er");
    }
}
