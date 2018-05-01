package com.holddie.niu.code.gan1804.gan0416;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/16 7:52
 */
public class Text0416 {
    public static void main(String[] args) {
        A a = new A(12) {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        System.out.println(a.aa);
    }
    long aLong = 123L;
    double aDouble = 0.123d;
}

abstract class A{
public int aa;

    protected A(int aa) {
        this.aa = aa;
    }
}
