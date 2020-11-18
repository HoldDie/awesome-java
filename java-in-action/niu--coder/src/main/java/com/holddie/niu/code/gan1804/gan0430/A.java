package com.holddie.niu.code.gan1804.gan0430;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/30 21:22
 */
public class A {
    A(){}
}

class B extends A{
    int ii;

//    B(){
//        super();
//    }

    B(int ii) {
        this.ii = ii;
    }

    public static void main(String[] args) {
        B b = new B(12);
        System.out.println(b.ii);
    }
}
