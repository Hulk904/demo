package com.demo.base.inherit;

import com.demo.base.serializable.Person;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by yangyuan on 8/18/17.
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //test 1
        enhancer.setSuperclass(Person.class);
        Person p = new Person();
        p.setAge(29);
        p.setName("hulk");
        enhancer.setCallback(new MyMethodInterceptor(p));
        Person person = (Person)enhancer.create();
        System.out.println("age====="+person.getAge());
//        Person child = new ChildClass();
//        System.out.println(child.getName());

        //test 2
//        enhancer.setSuperclass(AbstractClass.class);
//        AbstractClass concretClass = new ConcretClass();
//        concretClass.setName("concret");
//        enhancer.setCallback(new MyMethodInterceptor(concretClass));
//        AbstractClass ab = (AbstractClass)enhancer.create();
//        ab.sayHello();

    }
}
