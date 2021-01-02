package com.holddie.niu.code.gan1804.gan0427;

class CompareReference {
    public static void main(String[] args) {
        float f = 42.0f;
        float f1[] = new float[2];
        float f2[] = new float[2];
        float[] f3 = f1;
        long x = 42;
        f1[0] = 42.0f;


        System.out.println(f1[0]==x);
        System.out.println(f1==f3);
    }
}