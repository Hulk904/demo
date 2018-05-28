package com.demo.base.lambda.how_implement.invoke.t2;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by yangyuan on 5/28/18.
 */
public class Son extends GrandFather{
    void thinking(){
        //invoke grandFather method
        try{
            MethodType methodType = MethodType.methodType(void.class);
            MethodHandle methodHandle = MethodHandles.lookup().findVirtual(GrandFather.class,
                    "thinking", methodType).bindTo(new GrandFather());
            methodHandle.invokeExact();
        }catch (Throwable exc){
            System.out.println(exc);
        }
    }
}
