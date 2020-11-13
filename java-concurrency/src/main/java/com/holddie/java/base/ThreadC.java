package com.holddie.java.base;

import java.util.concurrent.Callable;

public class ThreadC implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(500);
		System.out.println("这是线程 C");
		return "线程 C";
	}
}
