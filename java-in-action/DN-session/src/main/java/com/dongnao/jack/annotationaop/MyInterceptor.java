package com.dongnao.jack.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyInterceptor {
    
    @Pointcut("execution(public * com.dongnao.jack.service..*.*(..))")
    public void myMethod() {
        System.out.println();
    }
    
    @Before("myMethod()")
    public void before() {
        System.out.println(" before annotation前置通知");
    }
    
    @After("myMethod()")
    public void after() {
        System.out.println(" after annotation后置通知");
    }
    
    @Around("myMethod()")
    public void around(ProceedingJoinPoint point) {
        System.out.println("around annotation前置通知");
        try {
            point.proceed();
        }
        catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("around annotation后置通知");
    }
}
