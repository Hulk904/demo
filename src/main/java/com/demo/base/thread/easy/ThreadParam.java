package com.demo.base.thread.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 16-11-23.
 */
public class ThreadParam {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        new MyThread(list1).start();
    }


}
class MyThread extends  Thread{

    List<String> list ;
    public MyThread( List list){
        this.list = list;
    }
    @Override
    public void run() {
        list = new ArrayList<String>();
    }
}