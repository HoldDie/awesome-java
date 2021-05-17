package com.holddie.java.async2sync;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncCall {
    private Random random = new Random(System.currentTimeMillis());

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public void call(BaseAsyncDemo demo) {
        new Thread(() -> {
            long res = random.nextInt(10);
            try {
                Thread.sleep(res * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.callBack(res);
        }).start();
    }

    public Future<Long> futureCall() {
        return executor.submit(() -> {
            long res = random.nextInt(10);
            try {
                Thread.sleep(res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return res;
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
