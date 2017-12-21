package com.demo.base.volatiletest;

/**
 * Created by yangyuan on 12/21/17.
 */
public class VolatileOneObjectTest implements Runnable{
    private volatile ObjectB a; // <span style="color:#ff0000;"><strong>加上volatile 就可以正常结束While循环了  </strong></span>
    public VolatileOneObjectTest(ObjectB a) {
        this.a = a;
    }

    public ObjectB getA() {
        return a;
    }

    public void setA(ObjectB a) {
        this.a = a;
    }

    @Override
    public void run() {
        long i = 0;
        while (a.isFlag()) {
            i++;
        }
        System.out.println("stop My Thread " + i);
    }

    public void stop() {
        a.setFlag(false);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
        System.out.println(System.getProperty("java.vm.name"));

        VolatileOneObjectTest test = new VolatileOneObjectTest(new ObjectB());
        new Thread(test).start();

        Thread.sleep(1000);
        test.stop();
        Thread.sleep(1000);
        System.out.println("Main Thread " + test.getA().isFlag());
    }

    static class ObjectB {
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }
}
