package com.demo.base.collection;

/**
 * Created by yangyuan77 on 2019/10/22.
 */
public class BaseItem {
    private Integer score;


    public BaseItem (Integer score){
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "score=" + score +
                '}';
    }
}
