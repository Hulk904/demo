package com.demo.base.classloader.spi;

/**
 * Created by yangyuan on 7/4/17.
 */
public class StartCommand implements Command{
    public void execute(){
        System.out.println(this.getClass().getClassLoader());
        System.out.println("start ...");
    }
}
