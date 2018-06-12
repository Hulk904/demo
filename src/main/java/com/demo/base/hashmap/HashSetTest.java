package com.demo.base.hashmap;

import java.util.HashSet;

/**
 * Created by yangyuan on 6/12/18.
 * 结果是2。为什么呢？当一个对象被存储在Hashset中后，
 * 如果修改参与计算hashcode有关的字段，
 * 那么修改后的hashcode的值就与一开始存储进来的hashcode的值不同了，
 * 这样contains无法通过hashcode找到该元素，所以无法删除。
 * 这就告诉我们，当一个对象被存储在Hashset中后，
 * 不要修改与计算hashcode有关的字段。
 */
public class HashSetTest {

    public static void main(String[] args)
    {
        HashSet<Point> hs2 = new HashSet<Point>();
        Point p21 = new Point(3, 3);
        Point p22 = new Point(3, 5);
        hs2.add(p21);
        hs2.add(p22);
        p22.setY(7);
        hs2.remove(p22);
        System.out.println(hs2.size());
    }
}
