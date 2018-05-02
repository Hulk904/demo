package com.demo.base.util;

/**
 * 一致性hash  java 实现
 * Created by yangyuan on 3/27/18.
 */
public class VirtualServerNode {
    private String serverNodeName;//这个名字指的是其对应的真实的物理服务器节点的名字
    private long virtualServerNodeHash;

    public VirtualServerNode(String serverNodeName, long virtualServerNodeHash) {
        this.serverNodeName = serverNodeName;
        this.virtualServerNodeHash = virtualServerNodeHash;
    }
    public String getServerNodeName() {
        return serverNodeName;
    }
    public void setServerNodeName(String serverNodeName) {
        this.serverNodeName = serverNodeName;
    }
    public long getVirtualServerNodeHash() {
        return virtualServerNodeHash;
    }
    public void setVirtualServerNodeHash(long virtualServerNodeHash) {
        this.virtualServerNodeHash = virtualServerNodeHash;
    }
}
