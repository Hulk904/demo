package com.demo.base.design_pattern.command_mode;

/**
 * Created by yangyuan on 1/29/18.
 * reciver  -- 具体执行的地方
 */
public class TV {

    private int currentChannel = 0;

    public  void turnOn(){
        System.out.println("tv turn on");
    }

    public void turnOff(){
        System.out.println("tv turn off");
    }

    public void changeChannel(int newChannel){
        System.out.println("channel change");
        this.currentChannel = newChannel;
    }
}
