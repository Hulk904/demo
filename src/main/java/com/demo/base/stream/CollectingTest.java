package com.demo.base.stream;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yangyuan on 5/23/18.
 */
public class CollectingTest {

    public static void main(String[] args) {

//        Iterator<Integer> iter = Stream.iterate(0, n -> n +1).limit(10).iterator();
//        while(iter.hasNext()){
//            System.out.println(iter.next());
//        }
        /*
        对象list转map
         */
        List<Person> list = Lists.newArrayList(new Person(1, "预约", "北京"),new Person(2, "基金法","上海"),new Person(3, "规定", "成都"));
        Map<Integer,Person> map = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(map);
    }



}
