package com.holddie.niu.code.gan0428;

class A{


    public static void main(String[] args) {

        A obj = new D();

        System.out.println(obj instanceof B);

        System.out.println(obj instanceof C);

        System.out.println(obj instanceof D);

        System.out.println(obj instanceof A);
    }
}

class B extends A{}

class C extends A{}

class D extends B{}

