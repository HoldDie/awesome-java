package com.holddie.java.op;

public class WaitAndNotify {
	public static void main(String[] args) {
		MethodClass methodClass = new MethodClass();
		new Thread(() -> {
			try {
				methodClass.product();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "productor-1").start();
		new Thread(() -> {
			try {
				methodClass.costomer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "costomer-1").start();
		new Thread(() -> {
			try {
				methodClass.costomer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "costomer-2").start();
	}


}

class MethodClass {
	private final int MAX_COUNT = 20;
	int productCount = 0;

	public synchronized void product() throws InterruptedException {
		while (true) {
			System.out.println(Thread.currentThread().getName() + ":::product:::" + productCount);
			Thread.sleep(10);
			if (productCount >= MAX_COUNT) {
				System.out.println("货仓已满，不必再生产");
				wait();
			} else {
				productCount++;
			}
			notifyAll();
		}
	}

	public synchronized void costomer() throws InterruptedException {
		while (true) {
			System.out.println(Thread.currentThread().getName() + ":::costomer:::" + productCount);
			Thread.sleep(10);
			if (productCount <= 0) {
				System.out.println("货仓已空，不用消费");
				wait();
			} else {
				productCount--;
			}
			notifyAll();
		}
	}
}
