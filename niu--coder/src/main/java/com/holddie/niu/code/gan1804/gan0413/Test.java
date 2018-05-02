package com.holddie.niu.code.gan1804.gan0413;

public class Test {
    static int x, y;

    static {
        int x = 5;
    }


    public static void main(String args[]) {
        x--;
        myMethod();
        System.out.println(x + y + ++x);
    }

    public static void myMethod() {
        y = x++ + ++x;
    }
}