package com.demo.base.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by yangyuan on 16-8-15.
 */
@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "", propOrder = { "head", "body" })
public class Request  extends BaseRequest<Body> {
    @XmlElement(name = "Head", required = true)
    @Override
    public Head getHead() {
        return head;
    }

    @Override
    public void setHead(Head value) {
        this.head = value;
    }

    @XmlElement(name = "Body", required = true)
    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void setBody(Body value) {
        this.body = value;
    }
}
