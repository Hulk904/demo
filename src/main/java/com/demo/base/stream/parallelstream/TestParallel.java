package com.demo.base.stream.parallelstream;

import com.demo.base.serializable.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 6/20/17.
 */
public class TestParallel {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        List<Person> list1 = new ArrayList<>();
//        list.add(new Person(12,"mei"));
//        list.add(new Person(13,"han"));
//        list.add(new Person(14,"jack"));
//        list.add(new Person(15,"herry"));
//        list.add(new Person(16,"hulk"));
//        list.add(new Person(17,"mak"));
//        list.add(new Person(18,"tina"));
//        list.add(new Person(19,"joe"));
       // list.parallelStream().forEach(s -> list1.add(s));
        System.out.println(list1);
    }
}
