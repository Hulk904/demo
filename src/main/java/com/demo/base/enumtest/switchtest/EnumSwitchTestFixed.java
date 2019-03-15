package com.demo.base.enumtest.switchtest;

import java.util.Arrays;

import com.demo.base.enumtest.EnumMaker;
import com.demo.base.enumtest.EnumMakerUtil;
import com.demo.base.enumtest.TestEnum;

/**
 * Created by yangyuan on 2019/3/8.
 *
 * @author yangyuan
 * @date 2019/03/08
 */
public class EnumSwitchTestFixed {
    public static void main(String[] args) {
        EnumMakerUtil.testSave();
        EnumMakerUtil.testUpdate();
        System.out.println(Arrays.deepToString(TestEnum.values()));
        EnumMakerUtil.testUpdate2();
        System.out.println(Arrays.deepToString(TestEnum.values()));
        EnumMakerUtil.testSwitch();
    }

}
