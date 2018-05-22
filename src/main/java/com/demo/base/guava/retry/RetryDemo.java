package com.demo.base.guava.retry;

import com.demo.base.thread.executor.HttpClientUtils;
import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.apache.commons.lang3.StringUtils;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 5/21/18.
 */
public class RetryDemo {

    public static void main(String[] args) {
        Retryer<Boolean> retry = RetryerBuilder.<Boolean>newBuilder()
                .retryIfRuntimeException()
                .retryIfResult(Predicates.equalTo(false))
                .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        try{
            retry.call(atomicCall);
        }catch (ExecutionException | RetryException exc){
            System.out.println("exception" + exc);
        }

    }

    private static Callable<Boolean> atomicCall = new Callable<Boolean>(){

        @Override
        public Boolean call() throws Exception {
            String  result = HttpClientUtils.sendHttpPost("www.jd.com",null);
            System.out.println(result);
            if(StringUtils.isEmpty(result)){
                throw new  RuntimeException("error");
            }
            if(result.length()>100){
                return true;
            }
            return false;
        }
    };
}
