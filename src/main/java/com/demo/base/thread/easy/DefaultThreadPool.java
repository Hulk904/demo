package com.demo.base.thread.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yangyuan on 17-1-7.
 */
public class DefaultThreadPool <Job extends Runnable> implements  ThreadPool<Job> {

    private static final int MAX_WORKER_NUMBERS =10;
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private static final int MIN_WORKER_NUMBERS = 1;
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializedWokers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num ){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num <MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS:num;
        initializedWokers(workerNum);
    }
    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker: workers){
            worker.shutDown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if(num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializedWokers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                throw new IllegalArgumentException("too big");
            }
            int count  = 0;
            while(count < num){
                Worker worder = workers.get(count);
                if(workers.remove(worder)){
                    worder.shutDown();
                    count ++;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializedWokers(int num ){
        for(int i =0 ;i < num ;i ++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    class Worker implements Runnable{
        private volatile boolean running = true;

        @Override
        public void run() {
            while(running){
                Job job =null;
                synchronized(jobs){
                    while (jobs.isEmpty()){
                        try{
                            jobs.wait();
                        }catch (InterruptedException ex){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();

                }
                if(job != null){
                    try{
                        job.run();
                    }catch (Exception ex){

                    }
                }
            }
        }
        public void shutDown(){
            running = false;
        }
    }
}
