package com.demo.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 16-8-25.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("123",new Integer(123));
        map.put(new Integer(111),"123");
        map.get(111);
        map.get(new Integer(111));
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("111","333");
        map1.put("555","777");
        //map1.put(123,"33");
        //System.out.println(new Integer(12)==new Integer(12));
        Object [] objects = new Object[2];
        objects[0] = "123";
        objects[1] = "111";
        String[] strings = (String[])objects;

        List<Object> objectList = new ArrayList<Object>();
        objectList.add("123") ;
        objectList.add("111") ;
//        List<String> strings1 = objectList;
    }
}
