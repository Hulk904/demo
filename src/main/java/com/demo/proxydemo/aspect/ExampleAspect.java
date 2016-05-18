package com.demo.proxydemo.aspect;

import org.aspectj.lang.annotation.*;

/**
 * Created by yangyuan on 16-5-18.
 */
@Aspect
public class ExampleAspect {
    @Pointcut("execution(* com.demo.proxydemo.aspect.*.*(..))")
    //@Pointcut("execution(* com.demo.thrift.support.impl.*.*(..))")
    public void aPointcut() {
    }

    @Before("aPointcut()")
    public void beforeAdvice() {
        System.out.println("before advice is executed!");
    }

    @AfterReturning(pointcut = "aPointcut()", returning="r")
    public void afterReturningAdvice(String r) {
        if (r != null)
            System.out.println("after returning advice is executed! returning String is : " + r);
    }

    @After("aPointcut()")
    public void AfterAdvice() {
        System.out.println("after advice is executed!");
    }

    @After("aPointcut() && args(str)")
    public void AfterAdviceWithArg(String str) {
        System.out.println("after advice with arg is executed!arg is : " + str);
    }

    @AfterThrowing(pointcut="aPointcut()",throwing="e")
    public void afterThrowingAdvice(Exception e) {
        System.out.println("after throwing advice is executed!exception msg is : " + e.getMessage());
    }



}
