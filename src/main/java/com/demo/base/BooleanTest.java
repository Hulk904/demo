package com.demo.base;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yangyuan on 2019/4/24.
 *
 * @author yangyuan
 * @date 2019/04/24
 */
public class BooleanTest {
    public static void main(String[] args) {
        //Boolean isTrue = null;
        //if (isTrue){//空指针异常
        //    System.out.println("true");
        //} else {
        //    System.out.println("false");
        //}
        System.out.println(creditFlag("{\"creditBuying\":\"{\\\"equityType\\\":\\\"0\\\","
            + "\\\"numberOfStages\\\":\\\"12\\\",\\\"isOnline\\\":\\\"1\\\",\\\"negoPrice\\\":349900,"
            + "\\\"startedAt\\\":1548683109000,\\\"expiredAt\\\":1580564714000}\"}"));

    }

    private static boolean creditFlag(Object alisportsAttributeStr) {
        if (alisportsAttributeStr == null || StringUtils.isBlank(alisportsAttributeStr.toString())) {
            return false;
        }
        if (JSON.parseObject(alisportsAttributeStr.toString()).get("creditBuying") != null) {
            String str = JSON.parseObject(alisportsAttributeStr.toString()).getString("creditBuying");
            try {
                if ("1".equals(JSON.parseObject(str).getString("isOnline"))) {
                    return true;
                }
            }catch (Exception exc){
                System.out.println(exc);
            }
        }
        return false;
    }

}
