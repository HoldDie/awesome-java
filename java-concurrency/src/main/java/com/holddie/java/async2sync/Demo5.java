package com.holddie.java.async2sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo5 extends BaseAsyncDemo {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    @Override
    public void callBack(long res) {
        System.out.println("callBack start");
        System.out.println(res);
        System.out.println("callBack end");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        demo5.call();
        try {
            demo5.cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("the main thread end.");
    }
}
