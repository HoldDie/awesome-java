package com.holddie.niu.code.gan0418;

public class Square {
    long width;

    public Square(long l) {
        width = l;
    }

    public static void main(String arg[]) {
        Square a, b, c;
        a = new Square(42L);
        b = new Square(42L);
        c = b;
        long s = 42L;

        System.out.println(a.equals(s));
        System.out.println(b==c);
        System.out.println(b.equals(c));
        b.toString();
    }
}