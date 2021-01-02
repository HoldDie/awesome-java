package com.holddie.java.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMain {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.start();
		System.out.println("这是主线程 A");

		ThreadB threadB = new ThreadB();
		new Thread(threadB).start();
		System.out.println("这是主线程 B");

		ThreadC threadC = new ThreadC();
		FutureTask<String> futureTask = new FutureTask<>(threadC);
		new Thread(futureTask).start();
		System.out.println("这是主线程 C");

		try {
			System.out.println("得到返回的结果是：" + futureTask.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}
}
