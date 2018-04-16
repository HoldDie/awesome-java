package com.holddie.niu.code.gan0415;

import java.awt.event.ContainerEvent;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/15 8:11
 */
public class Test {
    private ServerSocket serverSocket;

    {
        try {
//            serverSocket = new ServerSocket(9000,"localhost");  (x)
            serverSocket = new ServerSocket(9000); //(yes)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long i = 0xfffL;
        double ii = 0.9239d;
//        java/awt/event
//        ContainerEvent event = new ContainerEvent();

    }
}


abstract class A {
    static String adf() throws Exception{
        throw new NullPointerException();
    }
}