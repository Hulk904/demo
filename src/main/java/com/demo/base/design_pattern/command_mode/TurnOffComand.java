package com.demo.base.design_pattern.command_mode;

/**
 * Created by yangyuan on 1/29/18.
 */
public class TurnOffComand implements Command{
    private TV tv;

    public TurnOffComand (TV tv){
        tv.turnOff();
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
