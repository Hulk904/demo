package com.demo.base.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan77 on 2019/12/12.
 * 获取到泛型信息
 */
public class GenericInfo {

    public static void main(String[] args) {

        List<DemoBean> list = new ArrayList<DemoBean>(){};
        Type type = list.getClass().getGenericSuperclass();
        System.out.println(type);

        DemoBean2<DemoBean> demoBean2 = new DemoBean2(new Integer(1));
        demoBean2.getClass();

        DemoBean3 demoBean3 = new DemoBean3(new DemoBean());

        System.out.println(demoBean2);


    }
}
