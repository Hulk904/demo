package com.demo.base.lambda.how_implement.invoke.t2;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by yangyuan on 5/28/18.
 */
public class Son extends Father{
    void thinking(){
        //invoke grandFather method
        try{
            MethodType methodType = MethodType.methodType(void.class);
            MethodHandle methodHandle = MethodHandles.lookup().findVirtual(GrandFather.class,
                    "thinking", methodType).bindTo(new GrandFather());
            methodHandle.invokeExact();//i am grandfathcer.  这个是通过GrandFather对象调用的，而不是继承的方法啊，所以没啥可参考的

            MethodHandle methodHandle1 = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking",
                    methodType, this.getClass());
            methodHandle1.invoke(this);//i am father. 这个例子在jdk7,jdk8上都是这个结果
        }catch (Throwable exc){
            System.out.println(exc);
        }
    }
}
