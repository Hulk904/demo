package com.demo.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CloudId {
    /**
     * 加载集群ID值的加载因子
     */
    static final float _threshold = 0.5F;
    static volatile int state = -1;
    private final static int LOADING = 1;
    private final static int LOADED = 2;

    /**
     * 这里对外提供的唯一序列ID
     *
     * @return
     */
    public static long getCloudId() throws Exception {
        CloudIdContainer cloudIdContainer = getSingleton();
        return cloudIdContainer.getNode().getId();
    }


    private static volatile CloudIdContainer singleton = null;

    /**
     * 获取对应的值
     *
     * @return
     */
    public static CloudIdContainer getSingleton() {
        if (singleton != null) {
            return singleton;
        } else {
            //这里开始时候会执行到这里多个线程在这里阻塞，后边来的线程就不会阻塞了
            synchronized (CloudIdContainer.class) {
                if (singleton == null) {
                    singleton = new CloudIdContainer(100);
                }
            }
        }
        return singleton;
    }


    /**
     * 同步数据
     */
    static class CloudIdContainer {
        Lock lock = new ReentrantLock();
        Condition hasLoad = lock.newCondition();
        Condition canLoad = lock.newCondition();
        /**
         * 存放执行Node的map
         */
        private final Map<String, Node> nodeMap = new ConcurrentHashMap<>(2);

        private String[] currentKey;
        /**
         * 当前正在使用下标地址
         */
        private volatile int currentIndex = 0;
        /**
         * 最大加载NODE的容器数据默认是2
         */
        private final int loadSize = 2;

        private int step;//用于动态的调整请求的跨度
        private int threshold; //加载的阀值


        public CloudIdContainer(int stemp) {
            //增加系统探针
            currentKey = new String[loadSize];
            for (int i = 0; i < loadSize; i++) {
                currentKey[i] = String.valueOf(i);
                currentIndex = i;
            }
            this.step = stemp;
            threshold = (int) (_threshold * step);
        }


        /**
         * 计算获得生成并得到当前生产的节点
         *
         * @return
         */
        public Node getNode() throws Exception {
            Exception ee = null;
            //暂时设置首次加载时候时候调用返回，看压测结果后期修改是否需要预加载
            lock.lock();
            try {
                Node currentNode = nodeMap.get(currentKey[currentIndex]);
                //对象中还有值需要判断是否还可以产生
                if (null != currentNode) {
                    if (currentNode.isEmpty()) {
                        //重置为空
                        nodeMap.remove(currentKey[currentIndex]);
                        //移动下标指向
                        currentIndex = moveIndex();
                        //重新调用
                        return getNode();
                    }
                    //是否超过阀值,
                    if (currentNode.isUpLoad(threshold)) {
                        //触及到阈值可以预先加载
                        if (nodeMap.size() < loadSize) {
                            remoteLoad();
                        }
                    }
                    return currentNode;
                }
                //节点首次进来时候为空
                if (null == currentNode
                        && state < LOADING) {
                    //首次执行
                    remoteLoad();
                    while (state != LOADED) {
                        //设置返回的时间为100毫秒
                        canLoad.await(100, TimeUnit.MILLISECONDS);
                    }
                    currentIndex = moveIndex();
                    canLoad.signal();
                    return getNode();
                } else {
                    canLoad.signal();
                    return getNode();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ee = new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            if (null != ee) {
                throw ee;
            }
            throw new RuntimeException("执行获取节点时候失败");
        }


        /**
         * 生产对应的
         */
        private void remoteLoad() {
            state = LOADING;
            lock.lock();
            try {
                new Thread(() -> {
                    //这里加载
                    int movedIndex = moveIndex();
                    //预先加载对应值，TODO 这里需要调用远程的请求Handler
                    nodeMap.put(currentKey[movedIndex], new Node(101, 200));
                    state = LOADED;
                    hasLoad.signal();
                }).start();
                while (state != LOADED) {
                    hasLoad.await();
                }
                hasLoad.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

        /**
         * 移动游标
         *
         * @return
         */
        int moveIndex() {
            int _c = currentIndex;
            //下标值如果为越界重置
            if (_c == loadSize - 1) {
                _c = 0;
            } else {
                ++_c;
            }
            return _c;
        }

    }


    /**
     * 承载生成唯一ID的值
     */
    static class Node {
        private static volatile long current = -1;
        /**
         * 开始范围
         */
        private long start;
        /**
         * 截止范围
         */
        private long end;


        public Node(long start, long end) {
            this.start = start;
            this.end = end;
            //为了后续的都执行++ 操作
            current = start - 1;
        }

        /**
         * 判断是否为空，等待回收
         */
        boolean isEmpty() {
            return current == end;
        }

        /**
         * 计算是否超过了阀值
         */
        boolean isUpLoad(long threshold) {
            if (current + threshold > end) {
                return true;
            }
            return false;
        }

        /**
         * 获得ID值
         *
         * @return
         */
        public synchronized long getId() {
            if (current == -1L) {
                throw new RuntimeException("检查当前获取的current是否正确");
            }
            return ++current;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    System.out.println(CloudId.getCloudId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
