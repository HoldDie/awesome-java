package com.holddie.niu.code.gan1804.gan0427;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/27 7:24
 */
public class Test {
    Object object = new Object();
    void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        synchronized(Thread.currentThread())
        {
            obj.wait();
            System.out.println(1);
            obj.notify();
            System.out.println(2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
//        test.waitForSignal();



        // 同样也报错
        test.object.wait();
        System.out.println(3);
        test.object.notify();
        System.out.println(4);
    }
}
