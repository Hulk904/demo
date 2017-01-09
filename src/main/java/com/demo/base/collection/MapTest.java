package com.demo.base.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 16-11-21.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("123",1l);
        System.out.println((Integer)map.get("123"));
    }
}
