package com.demo.base.volatiletest;

/**
 * Created by yangyuan on 12/21/17.
 */
public class VolatileObjectTest implements Runnable {
    private     ObjectA a;
    public VolatileObjectTest(ObjectA a) {
        this.a = a;
    }

    public ObjectA getA() {
        return a;
    }

    public void setA(ObjectA a) {
        this.a = a;
    }

    @Override
    public void run() {
        long i = 0;
        ObjectASub sub = a.getSub();
        while (!sub.isFlag()) {
            i++;
        }
        System.out.println("stop My Thread " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
        System.out.println(System.getProperty("java.vm.name"));
        ObjectASub sub = new ObjectASub();
        ObjectA sa = new ObjectA();
        sa.setSub(sub);
        VolatileObjectTest test = new VolatileObjectTest(sa);
        new Thread(test).start();

        Thread.sleep(1000);
        sub.setFlag(true);
        Thread.sleep(1000);
        System.out.println("Main Thread " + sub.isFlag());
    }

    static class ObjectA {
        private   ObjectASub sub;

        public ObjectASub getSub() {
            return sub;
        }

        public void setSub(ObjectASub sub) {
            this.sub = sub;
        }
    }

    static class ObjectASub{
        private  volatile boolean flag;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }
}
