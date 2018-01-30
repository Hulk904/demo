package com.demo.base.collection;

import com.demo.base.serializable.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 6/22/17.
 */
public class List2Map {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
//        list.add(new Person(1,"aa"));
//        list.add(new Person(2,"bb"));
//        list.add(new Person(3,"cc"));
        Map<Integer,String> map = list.stream().collect(Collectors.toMap(Person::getAge,Person::getName));
        System.out.println(map);
    }
}
