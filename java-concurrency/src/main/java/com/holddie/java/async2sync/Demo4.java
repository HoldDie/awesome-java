package com.holddie.java.async2sync;

import java.util.concurrent.CountDownLatch;

public class Demo4 extends BaseAsyncDemo {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void callBack(long res) {
        System.out.println("得到结果");
        System.out.println(res);
        System.out.println("调用结束");
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        demo4.call();

        try {
            demo4.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程内容");
    }
}
