package com.demo.base.design_pattern.command_mode;

/**
 * Created by yangyuan on 1/29/18.
 */
public class Controller {

    private Command turnOffCommand,turnOnCommand,changeChannel;

    public Controller(Command turnOffCommand,Command turnOnCommand,Command changeChannel){
        this.turnOffCommand = turnOffCommand;
        this.turnOnCommand = turnOnCommand;
        this.changeChannel = changeChannel;
    }

    public void turnOff(){
        turnOffCommand.execute();
    }

    public void turnOn(){
        turnOnCommand.execute();
    }

    public void channelChange(int newChannel){
        changeChannel.execute();
    }
}
