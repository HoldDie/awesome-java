package com.dongnao.jack.aop;

public class IntroductionClass implements IntroductionIntf {
    
    public void extend() {
        System.out.println("我是切面Introduction引入的方法");
    }
}
