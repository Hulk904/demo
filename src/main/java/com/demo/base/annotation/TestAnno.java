package com.demo.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yangyuan on 5/29/18.
 */
public class TestAnno {
    public static void main(String[] args) throws NoSuchMethodException,NoSuchFieldException,IllegalAccessException{
        Method method = TestAnno.class.getMethod("hello", String.class);
        Anno anno = method.getAnnotation(Anno.class);
        System.out.println(anno.name());//输出hulk ，跟对象没关系（不需要new个对象）
        //动态代理获取注解对象  ， 实际上上面的方法返回的注解对象本身也是通过动态代理生产的（可以去跟跟源码）
        Anno anno2 = getAnnonation();
        Field field = anno2.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(anno2, Anno.class.getName());
        System.out.println(anno2.name());
    }
    @Anno(name = "hulk")
    public void hello(String name){
        System.out.println(name);
    }

    public static Anno getAnnonation(){
        return (Anno) Proxy.newProxyInstance(TestAnno.class.getClassLoader(),
                new Class[]{Anno.class},
                (proxy, method, args) -> null);
    }
}

