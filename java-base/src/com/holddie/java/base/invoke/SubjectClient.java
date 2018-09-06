package com.holddie.java.base.invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 具体实现调用
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/9/6 10:27
 */
public class SubjectClient {

    public static void main(String[] args) {
        // 指定被代理类
        ISubject subject = new SubjectImpl();
        InvocationHandler invocationHandler = new DynamicSubjectImpl(subject);
        Class cls = subject.getClass();
        System.out.println(cls.toString());
        System.out.println(cls.getClassLoader());
        Class[] interfaces1 = cls.getInterfaces();
        for (Class clss :
                interfaces1) {
            System.out.print(clss.getName() + ",");
        }
        System.out.println("\n=========================");


        // 动态代理方式
        ISubject subject1 = (ISubject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), invocationHandler);
        System.out.println(subject1 instanceof Proxy);

        System.out.println(subject1.getClass().toString());
        System.out.println("subject 中的属性有：");
        Field[] fields = subject1.getClass().getDeclaredFields();
        for (Field fiel :
                fields) {
            System.out.print(fiel.getName() + ",");
        }

        System.out.println("subject 中的方法有：");
        Method[] methods = subject1.getClass().getDeclaredMethods();
        for (Method meth :
                methods) {
            System.out.print(meth.getName() + ",");
        }

        System.out.println();
        System.out.println("subject 的父类是：" + subject1.getClass().getSuperclass());
        System.out.println("subject 的实现接口是：");
        Class[] interfaces = subject1.getClass().getInterfaces();
        for (Class clss :
                interfaces) {
            System.out.print(clss.getName() + ",");
        }

        System.out.println("运行结果为：");
        subject1.request();
    }

}
