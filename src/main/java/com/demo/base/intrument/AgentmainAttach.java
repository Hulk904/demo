package com.demo.base.intrument;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author yangyuan
 * @date 20-7-23.
 */
public class AgentmainAttach {

    public static void main(String[] args) throws IOException, AttachNotSupportedException,
            AgentLoadException, AgentInitializationException {
        //56397 待绑定的jvm进程的pid号,可以直接main启动的jvm进程
        VirtualMachine vm = VirtualMachine.attach("56397");
        //下面第一个参数是 agent的包路径，而不是要被监控的进程对应的
        //第二个参数是被代理（监控）的类及方法，可以不在一个工程中，通常也不会在一个工程中。
        vm.loadAgent("/home/yangyuan/IdeaProjects/demo/target/demo-1.0.0.jar", "com.wanmei.MyAgentTest&hello");
    }
}
