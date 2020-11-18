package com.holddie.niu.code.gan1805;

abstract class Animal {
    abstract void say();
}

public class Cat extends Animal {
    public Cat() {
        System.out.printf("I am a cat");
    }

    @Override
    void say() {

    }

    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}