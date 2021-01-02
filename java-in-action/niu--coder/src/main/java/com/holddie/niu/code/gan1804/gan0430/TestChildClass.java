package com.holddie.niu.code.gan1804.gan0430;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/30 21:31
 */
public class TestChildClass {
    public static void main(String[] args) throws Exception {
        //获取子类
        Class clazz = Class.forName("com.holddie.niu.code.gan1804.gan0430.Child");
        //得到父类
        Class superClass = clazz.getSuperclass();
        //得到父类非继承的所以方法
        Method[] methods = superClass.getDeclaredMethods();
        //设置私有方法可以被访问
        AccessibleObject.setAccessible(methods, true);
        for (Method m : methods) {
            System.out.println();
            System.out.println("子类调用方法" + m.getName() + "()的调用结果:");
            m.invoke(new Child());
        }

    }
}
