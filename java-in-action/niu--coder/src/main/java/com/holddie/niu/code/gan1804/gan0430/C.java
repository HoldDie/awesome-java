package com.holddie.niu.code.gan1804.gan0430;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/30 21:25
 */
public interface C {
    String method();
//    C();
abstract void a();
    static void s() {
    }
    default void d(){
    }
    void b();//默认用abstract修饰
    int a = 0;//默认用static final 修饰
}
