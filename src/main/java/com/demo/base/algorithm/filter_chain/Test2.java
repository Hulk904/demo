package com.demo.base.algorithm.filter_chain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 8/21/18.
 */
public class Test2 {
    public static void main(String[] args) {
        List<Filter> filters = Arrays.asList(new Filter1(), new Filter2());
        Invoker last = () -> {
            System.out.println("invoker");
            return 0;
        };

        for(int i = filters.size() - 1; i >= 0; i--) {
            // 获取filter
            final Filter filter = filters.get(i);
            final Invoker next = last;

            // 更新last
            last = () -> filter.invoke(next);
        }
        last.invoke();
    }


}
