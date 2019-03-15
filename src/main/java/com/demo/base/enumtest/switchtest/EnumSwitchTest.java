package com.demo.base.enumtest.switchtest;

import com.demo.base.enumtest.EnumMakerUtil;

/**
 * Created by yangyuan on 2019/3/8.
 *
 * @author yangyuan
 * @date 2019/03/08
 */
public class EnumSwitchTest {
    public static void main(String[] args) {
        EnumMakerUtil.testAdd();
        System.out.println("====one====");
        EnumMakerUtil.testSwitch();
        EnumMakerUtil.testAdd2();
        System.out.println("====two====");
        EnumMakerUtil.testSwitch();
    }
}
