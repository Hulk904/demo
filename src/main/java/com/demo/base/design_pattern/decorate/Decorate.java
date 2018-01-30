package com.demo.base.design_pattern.decorate;

/**
 * Created by yangyuan on 1/30/18.
 */
public class Decorate implements Human{

    private Human human;

    public Decorate(Human human){
        this.human = human;
    }

    @Override
    public void wearCloser() {
        human.wearCloser();
    }

    @Override
    public void walkToWhere() {
        human.walkToWhere();
    }
}
