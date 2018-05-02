package com.demo.base.reflect.from_map;

import com.google.common.collect.Lists;
import net.sf.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 3/26/18.
 */
public class Test {
    public static void main(String[] args) {
        Map<String ,Object> map = new HashMap<>();
        map.put("id",124);
        map.put("name","zhangsan");
        BeanA beanA = new BeanA();
        mapToBean(map,beanA);
        System.out.println(beanA);
    }

    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }


}
