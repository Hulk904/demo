package com.demo.base.jdk8.optional;

//import java.util.Optional;

/**
 * Created by yangyuan on 3/27/18.
 * 在bean为null或者bean的a属性为null的时候都会返回orElse的值。
 * Optional的get方法，如果没有数据会报空指针异常
 */
public class Test {
    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setA(444);
      //  Optional<Bean> b = Optional.ofNullable(bean);
       // System.out.println(b.map(t -> t.getA()).orElse(23));
    }
}
