package com.demo.base.algorithm.filter_chain;

/**
 * Created by yangyuan on 8/21/18.
 */
public interface Filter {
    int invoke(Invoker invoker);
}
class Filter1 implements Filter{

    public int invoke(Invoker invoker) {
        System.out.println("Filter1 invoker");
        return invoker.invoke();
    }
}

class Filter2 implements Filter{
    public int invoke(Invoker invoker) {
        System.out.println("Filter2 invoker");
        return invoker.invoke();
    }
}