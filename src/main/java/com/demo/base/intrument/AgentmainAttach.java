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
        VirtualMachine vm = VirtualMachine.attach("46005");//21887是待绑定的jvm进程的pid号
        vm.loadAgent("/home/yangyuan/IdeaProjects/test/target/test-1.0-SNAPSHOT.jar", "com.wanmei.MyAgentTest&hello");
    }
}
