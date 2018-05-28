package com.demo.base.lambda.how_implement.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 动态调用System.out 或者 ClassA 的 println() 方法
 * Created by yangyuan on 5/28/18.
 */
public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable{
        Object object = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintMH(object).invokeExact("yangyuan");

    }

    private static MethodHandle getPrintMH(Object receiver)throws Exception{//模拟了invokevirtual指令的执行过程
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
}
