package com.demo.thrift.support;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by yangyuan on 16-4-29.
 */
@Aspect
public class AfterReturningAdviceTest {
    @Pointcut("execution(* com.demo.thrift.support.impl.*.*(..))")
    //@Pointcut("execution(* com.demo.thrift.support.impl.*.*(..))")
    public void aPointcut() {
    }

    @Before("aPointcut()")
    public void log()
    {
        System.out.println("模拟记录日志功能 ...");
    }
}
