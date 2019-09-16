package com.demo.base;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2019/9/11.
 *
 * @author yangyuan
 * @date 2019/09/11
 */
public class RandomTest {
    //红包最小值
    private static final Integer MINVALUE = 10;
    //红包最大值
    private static final Integer MAXVALUE = 100;

    /**
     * 这里为了避免某一个红包占用大量资金，我们需要设定非最后一个红包的最大金额，我们把他设置为红包金额平均值的N倍；
     */
    private static final float TIMES = 2.1F;

    /**
     * 判断红包是否合情理
     * @param money
     * @param count
     * @return
     */
    public boolean isRight(float money,int count) {
        float avg = money/count;
        if(avg < MINVALUE) {
            return false;
        } else if(avg > MAXVALUE) {
            return false;
        }
        return true;
    }

    /**
     * 分红包核心算法
     * @param money
     * @param minS
     * @param maxS
     * @param count
     * @return
     */
    public Integer randomRedPacket(Integer money,Integer minS,Integer maxS,Integer count) {
        //当人数剩余一个时，把当前剩余全部返回
        if(count == 1) {
            return money;
        }
        //如果当前最小红包等于最大红包，之间返回当前红包
        if(minS == maxS) {
            return minS;
        }
        int max = maxS>money?money:maxS;
        //随机产生一个红包
        int one = (int)(Math.random()*(max-minS)+minS);
        float balance = money - one;
        //判断此次分配后，后续是否合理
        if(isRight(balance,count-1)) {
            return one;
        } else {
            //重新分配
            float avg = balance/(count-1);
            //如果本次红包过大，导致下次不够分，走这一条
            if(avg < MINVALUE) {
                return randomRedPacket(money, minS, one, count);
            } else {
                return randomRedPacket(money, one, maxS, count);
            }
        }
    }

    /**
     * 分红包
     * @param money
     * @param count
     * @return
     */
    public List<Integer> spiltRedPackets(Integer money,Integer count) {
        //首先判断红包是否合情理
        if(!isRight(money,count)) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int max = (int)(money/count*TIMES);
        max = max>money?money:max;
        for(int i = 0 ; i < count; i++) {
            Integer value = randomRedPacket(money,MINVALUE,max,count-i);
            list.add(value);
            money -= value;
        }
        return list;
    }

    public static void main(String[] args) {
        RandomTest red = new RandomTest();
        System.out.println(JSON.toJSONString(red.spiltRedPackets(200,12)));
    }

}
