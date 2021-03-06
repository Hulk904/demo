package com.demo.base.generic;

import com.demo.base.clone.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 16-9-30.
 *
 */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("", 12));
        Person p = list.get(0);
        System.out.println(p);
        try {
            say(String.class);
        }catch (Exception exc){
            System.out.println("=="+exc);
        }

    }

    /**
     * T 可用于定义变量
     * param 是类对象 ,可以实例化生成对象.
     * @param param
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T say(Class<T> param) throws  Exception{
        System.out.println(param);
        T t = param.newInstance();
        return  t;
    }
}
