package com.demo.base.maporder;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yangyuan on 16-6-12.
 */
public class MapOrderTest {
    public static void main(String[] args) {
        Map<String ,Integer> map =  new LinkedHashMap<String, Integer>();
        map.put("a",2);
        map.put("c",2);
        map.put("b",2);
        map.put("d",2);
        map.put("e",2);
        map.put("a",3);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Map<String,String> treeMap = new TreeMap<>();
        treeMap.put("f","===");
        treeMap.put("e","===");
        treeMap.put("d","===");
        treeMap.put("c","===");
        treeMap.put("a","===");
        treeMap.put("b","===");
        Iterator i = treeMap.entrySet().iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
