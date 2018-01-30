package com.demo.base.design_pattern.command_mode;

/**
 * Created by yangyuan on 1/29/18.
 */
public class ChangeChannel implements Command{

    private int channel;

    private TV tv;

    public ChangeChannel(TV tv,int channel){
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}
