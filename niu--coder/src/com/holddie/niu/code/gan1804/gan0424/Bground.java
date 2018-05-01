package com.holddie.niu.code.gan1804.gan0424;

public class Bground extends Thread {
    public static void main(String argv[]) {
        Bground b = new Bground();
        b.start();
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Value of i = " + i);
        }
    }
}