package com.holddie.java.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaemonThread {

	private static Logger logger = LoggerFactory.getLogger(DaemonThread.class);

	public static void main(String[] args) {
		Runnable task = () -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread t = Thread.currentThread();
			logger.info("当前线程：{}", t.getName());
		};
		Thread thread = new Thread(task);
		thread.setName("test-thread-1");
		thread.setDaemon(false);
		thread.start();
	}
}
