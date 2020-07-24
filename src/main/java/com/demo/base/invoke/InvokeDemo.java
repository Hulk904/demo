package com.demo.base.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author yangyuan
 * @date 20-7-21.
 */
public class InvokeDemo {
    public String getString(String s){
        return "hello, " + s;
    }

    public static void main(String[] args) throws Throwable {
        InvokeDemo demo = new InvokeDemo();
        MethodHandle handle = getHandle();
        String s = (String)handle.invokeExact(demo, "hulk");
        System.out.println(s);
        System.out.println(handle.invokeExact(demo, "hulk"));//报错
        System.out.println(handle.invoke(demo, "hulk"));//ok

    }

    public static MethodHandle getHandle() throws NoSuchMethodException, IllegalAccessException {
        MethodType type = MethodType.methodType(String.class, String.class);
        MethodHandle handle = MethodHandles.lookup().findVirtual(InvokeDemo.class, "getString", type);
        return handle;
    }
}
