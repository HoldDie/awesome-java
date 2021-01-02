package com.dongnao.jack.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyInterceptor implements MethodInterceptor {
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        return result;
    }
    
    private void before() {
        System.out.println("自定义MethodInterceptor前置增强");
    }
}
