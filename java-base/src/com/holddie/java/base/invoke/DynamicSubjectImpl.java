package com.holddie.java.base.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 动态代理实现接口方法
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/9/6 10:24
 */
public class DynamicSubjectImpl implements InvocationHandler {

    private Object object;

    public DynamicSubjectImpl() {
    }

    public DynamicSubjectImpl(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);

        method.invoke(object, args);

        System.out.println("after calling " + method);
        return null;
    }
}
