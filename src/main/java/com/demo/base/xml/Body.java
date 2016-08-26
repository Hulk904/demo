package com.demo.base.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by yangyuan on 16-8-15.
 */
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "dept"
})
public class Body extends BaseBody {
    @XmlElement(name = "name", required = true)
    protected String name;

    @XmlElement(name = "dept", required = true)
    protected String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
