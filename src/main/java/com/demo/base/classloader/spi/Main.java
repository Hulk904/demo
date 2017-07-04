package com.demo.base.classloader.spi;

import java.util.ServiceLoader;

/**
 * Created by yangyuan on 7/4/17.
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Command> serviceLoader=ServiceLoader.load(Command.class);
        for(Command command:serviceLoader){
            command.execute();
        }
    }
}
