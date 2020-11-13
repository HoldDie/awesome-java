package com.holddie.java.base;

public class ThreadMain2 {
	public static void main(String[] args) {
		ThreadB threadB = new ThreadB();

		for (int i = 0; i < 5; i++) {
			new Thread(threadB, "自定义线程名称-" + i).start();
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread currentThread = Thread.currentThread();
		System.out.println("这是主线程");
		System.out.println("返回当前线程组中活动线程数目：" + currentThread.activeCount());
		System.out.println("主线程的名称：" + currentThread.getName());
		System.out.println("返回该线程的标识符：" + currentThread.getId());
		System.out.println("返回该线程的优先级：" + currentThread.getPriority());
		System.out.println("返回该线程的状态：" + currentThread.getState());
		System.out.println("返回该线程的所属的组：" + currentThread.getThreadGroup());
		System.out.println("返回该线程是否为守护线程：" + currentThread.isDaemon());
	}

}
