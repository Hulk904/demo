package com.demo.base.xml;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by yangyuan on 16-8-15.
 */
@XmlTransient
public abstract  class BaseRequest <T extends BaseBody>{
    protected Head head;
    protected T body;

    public abstract Head getHead();
    public abstract void setHead(Head value);
    public abstract T getBody();
    public abstract void setBody(T value);
}
