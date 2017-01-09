package com.demo.base.thread.easy;

/**
 * Created by yangyuan on 17-1-7.
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorkers(int num);
    void removeWorker(int num);
    int getJobSize();
}
