package com.demo.base.design_pattern.command_mode;

/**
 * Created by yangyuan on 1/29/18.
 */
public class TurnOnCommand implements Command{

    private TV tv;

    public TurnOnCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}
