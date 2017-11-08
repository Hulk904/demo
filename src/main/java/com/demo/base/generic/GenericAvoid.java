package com.demo.base.generic;

import com.demo.base.serializable.Person;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 8/17/17.
 */
public class GenericAvoid {
    public static void main(String[] args) throws Exception{
        Map<Long,Person> map = new HashMap<>();
        Person person = new Person();
        person.setAge(12);
        person.setName("yy");
        //map.put("123",person);
        Method method = map.getClass().getMethod("put",Object.class,Object.class);
        method.invoke(map,"123",person);//跳过了类型检查，插入成功。key为String的
        System.out.println(map);
    }
}
