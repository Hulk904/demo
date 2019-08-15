package com.demo.base.generic;

import java.util.Map;

/**
 * Created by yangyuan on 2019/5/13.
 *
 * @author yangyuan
 * @date 2019/05/13
 */
public class Test123 {

    public static void main(String[] args) {
        Map<String, Object> map1 = null;
        Map<String, String> map2 = null;

        test(map1);
        test(map2);
    }

    private static void test(Map<String, ?> settings) {}
}
