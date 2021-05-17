package com.holddie.java.async2sync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Demo3 {

    private AsyncCall asyncCall = new AsyncCall();

    public Future<Long> call() {
        Future<Long> longFuture = asyncCall.futureCall();
        asyncCall.shutdown();
        return longFuture;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        System.out.println("发起调用");
        Future<Long> future = demo3.call();
        System.out.println("返回结果");

        while (!future.isCancelled() && !future.isDone()) {
            ;
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程内容");
    }
}
