package com.holddie.niu.code.gan1804.gan0421;

public class Test {
    public static Test t1 = new Test();

    static {
        System.out.println("blockB");
    }
    {
        System.out.println("blockA");
    }
    public int x;


    public static void main(String[] args) {
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));
//        System. out. println("Value is" + x);
//        Test t2 = new Test();
    }
}