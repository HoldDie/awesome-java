package com.holddie.java.op;

public class Join {
	public static void main(String[] args) {
		Object obj = new Object();
		MyThread myThread = new MyThread("myThread -- ");
		myThread.setObject(obj);
		myThread.start();
		synchronized (myThread) {
			for (int i = 0; i < 100; i++) {
				if (i == 80) {
					try {
						myThread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " -- " + i);
			}
		}
	}
}

class MyThread extends Thread {
	private String name;
	private Object object;

	public MyThread(String name) {
		this.name = name;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				System.out.println(name + "-" + i);
			}
		}
	}
}
