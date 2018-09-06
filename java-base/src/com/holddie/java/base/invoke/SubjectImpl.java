package com.holddie.java.base.invoke;

/**
 * 实现类
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/9/6 10:22
 */
public class SubjectImpl implements ISubject {

    @Override
    public void request() {
        System.out.println("From real Subject. ");
    }
}
