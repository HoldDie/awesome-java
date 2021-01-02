package com.holddie.java.base;

public class ThreadB extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("这是线程 B");
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();

		System.out.println("这是线程名称：" + threadName);
		System.out.println("返回当前线程的线程组中的线程的数量：" + currentThread.getThreadGroup().activeCount());
		System.out.println("返回该线程的标识符：" + currentThread.getId());
		System.out.println("返回该线程的优先级：" + currentThread.getPriority());
		System.out.println("返回该线程的状态：" + currentThread.getState());
		System.out.println("返回该线程所属的线程组：" + currentThread.getThreadGroup());
		System.out.println("返回该线程是否处于活跃状态：" + currentThread.isAlive());
		System.out.println("返回该线程是否为守护线程：" + currentThread.isDaemon());
		System.out.println("返回该线程是否中断：" + currentThread.isInterrupted());
	}
}
