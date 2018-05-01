package com.holddie.niu.code.gan1804.gan0430;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/30 20:54
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(123);
        Thread[] ths = new Thread[3];
        for (int i = 0; i < 3; i++) {
            ths[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(j);
                    }
                    System.out.print(" ");
                }
            });
        }


        for (Thread th : ths) {
            th.start();
        }
    }
}
