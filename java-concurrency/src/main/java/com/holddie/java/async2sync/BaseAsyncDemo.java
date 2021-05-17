package com.holddie.java.async2sync;

public abstract class BaseAsyncDemo {

    protected AsyncCall asyncCall = new AsyncCall();

    public abstract void callBack(long res);

    public void call() {
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }
}
