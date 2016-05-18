package com.demo.proxydemo.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yangyuan on 16-5-18.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-thrift-client.xml");
        UserManager um =  context.getBean("userManager",UserManager.class);
        System.out.println("------ Case 1 --------");
        um.addUser("hey");
        System.out.println("------ Case 2 --------");
        try {
            um.editUser();
        } catch (Exception e) {

        }
        System.out.println("------ Case 3 --------");
        um.getUser();
    }

}
