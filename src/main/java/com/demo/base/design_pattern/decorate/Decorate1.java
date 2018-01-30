package com.demo.base.design_pattern.decorate;

/**
 * Created by yangyuan on 1/30/18.
 */
public class Decorate1 extends Decorate{


    public Decorate1(Human human){
        super(human);
    }


    public void wear(){
        System.out.println("在主卧找");
    }

    public void toWhere(){
        System.out.println("柜子");
    }

    @Override
    public void wearCloser() {
        super.wearCloser();
        wear();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        toWhere();
    }
}
