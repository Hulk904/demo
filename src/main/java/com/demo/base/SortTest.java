package com.demo.base;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * Created by yangyuan on 2019/9/9.
 *
 * @author yangyuan
 * @date 2019/09/09
 */
public class SortTest {

    public static void main(String[] args) {
        List<Param> list = Lists.newArrayList();
        list.add(new Param(false, 12.23D));
        list.add(new Param(true, 123.123D));
        list.add(new Param(false, 45.23D));
        list.add(new Param(true, 23.123D));
        Entity entry = new Entity();
        entry.setParamList(list);
        entry.getParamList().sort(Comparator.comparing(Param::getDistance));
        System.out.println(entry);
    }


}

class Entity{
    List<Param> paramList;

    public List<Param> getParamList() {
        return paramList;
    }

    public void setParamList(List<Param> paramList) {
        this.paramList = paramList;
    }
}

class Param{
    Boolean flag;

    Double distance;

    public Param(Boolean flag, Double distance){
        this.flag = flag;
        this.distance = distance;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}