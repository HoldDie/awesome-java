package com.holddie.java.async2sync;

public class Demo1 extends BaseAsyncDemo {

    private final Object lock = new Object();

    @Override
    public void callBack(long res) {
        System.out.println("得到结果");
        System.out.println(res);
        System.out.println("调用结束");

        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.call();

        synchronized (demo1.lock) {
            try {
                demo1.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程内容");
    }
}
