package com.holddie.niu.code.gan1804.gan0418;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/18 8:43
 */
public class Test {
    public static void main(String[] args) {
        boolean isOdd = false;
        int a = 0;
        for (int i = 1; i <= 2; ++i) {
            if (i % 2 == 1) isOdd = true;
            else isOdd = false;
            a += i * (isOdd ? 1 : -1);
        }
        System.out.println(a);
    }
}
