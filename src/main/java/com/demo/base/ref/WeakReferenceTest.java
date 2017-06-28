package com.demo.base.ref;

import java.lang.ref.WeakReference;

/**
 * Created by yangyuan on 6/28/17.
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> wr = new WeakReference<Object>(o);

        System.out.println(wr.get());//java.lang.Object@19e0bfd
        o = null;
        System.gc();
        System.out.println(wr.get());//null
    }
}
