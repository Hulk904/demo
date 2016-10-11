package com.demo.base.thread.executor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 16-9-8.
 */
public class TaskUnit implements Runnable{
    @Override
    public void run() {
        System.out.println("hihihi");
        try {
            Map<String,String> map = new HashMap<String, String>();
            map.put("xml","<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><Request xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://open.fangcang.com/v2.0/\"><Header TimeStamp=\"2016-09-08 16:02:59\" Signature=\"AF5360B2E695C3147607E17BD8A4356B\" RequestType=\"queryOrderList\" PartnerCode=\"F01114815\"/><Body><OrderID>H0212160907103115</OrderID><PageNo>1</PageNo><PageSize>20</PageSize></Body></Request>");
            HttpClientUtils.sendHttpPost("http://www.fangcang.com/Hub/v2.0/QueryOrderList",map);
        }catch (Exception exc){
            //do nothing
        }
        System.out.println("aaaaa");
    }
}
