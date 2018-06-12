package com.demo.base.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 6/5/18.
 */
public class Test {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{temp, i};
            }
            map.put(map.get(i), i);
        }
        throw new RuntimeException("not found");
    }
}
