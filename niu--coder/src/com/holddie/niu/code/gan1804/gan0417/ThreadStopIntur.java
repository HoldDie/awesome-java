package com.holddie.niu.code.gan1804.gan0417;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/17 8:14
 */
public class ThreadStopIntur {


    public static void main(String[] args) {
        Thread3 t = new Thread3();
        t.start();
        int index = 0;
        boolean flag = true;
        while (flag) {
            if (index++ == 50) {
                t.stopStop(); //终端t的线程，此时就会抛出异常 t.interrupt(); break;
//                t.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("main exit");
    }
}

class Thread3 extends Thread {
    private boolean isStop = false;

    public synchronized void run() {
        while (!isStop) {
            try {
                wait(); //进入到对象的等待队列需要有notify方法去唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
                if (isStop) return;
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void stopStop() {
        isStop = true;
    }

}
