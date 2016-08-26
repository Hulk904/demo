package com.demo.base.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * Created by yangyuan on 16-8-15.
 */
public class Document {

    private BaseRequest<? extends BaseBody> request;
    @XmlElement(name = "Request")
    public BaseRequest<? extends BaseBody> getRequest() {
        return request;
    }

    public void setRequest(BaseRequest<? extends BaseBody> request) {
        this.request = request;
    }


}
