package com.demo.base.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by yangyuan on 2019/1/8.
 *
 * @author yangyuan
 * @date 2019/01/08
 */
public class FutureException {

    public static void main(String[] args) {
        CompletableFuture<Boolean> f = CompletableFuture.supplyAsync(() ->{
            if(true){
                throw new RuntimeException("error.");
            }
            return true;
        });
        try {
            f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
