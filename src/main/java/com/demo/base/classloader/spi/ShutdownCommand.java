package com.demo.base.classloader.spi;

/**
 * Created by yangyuan on 7/4/17.
 */
public class ShutdownCommand implements Command{
    public void execute(){
        System.out.println(this.getClass().getClassLoader());
        System.out.println("shut down ....");
    }
}
