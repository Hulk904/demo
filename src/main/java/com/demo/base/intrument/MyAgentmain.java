package com.demo.base.intrument;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author yangyuan
 * @date 20-7-23.
 */
public class MyAgentmain {

    public static void agentmain(String agentOps, Instrumentation inst) throws UnmodifiableClassException {
        String[] args = agentOps.split("&");

        for(Class clazz : inst.getAllLoadedClasses()) {
            if(clazz.getName().equals(args[0])) {
                // 绑定ClassFileTransformer
                inst.addTransformer(new MyTransformer(args[0], args[1]), true);
                // 对已加载类重新转换处理
                inst.retransformClasses(clazz);
            }
        }
    }
}
