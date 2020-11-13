package com.holddie.java.base;

public class RunnerMain {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runner1());
		Thread thread2 = new Thread(new Runner2());

		thread1.start();
		thread2.start();

		thread2.interrupt();

		System.out.println("-------");
		System.out.println("Thread.activeCount() :" + Thread.activeCount());
		System.out.println("Thread.currentThread().getThreadGroup().list(): \n");
		Thread.currentThread().getThreadGroup().list();
		System.out.println("Thread.currentThread().getThreadGroup().getParent().activeGroupCount():" + Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
		System.out.println("Thread.currentThread().getThreadGroup().getParent().list(): \n");
		Thread.currentThread().getThreadGroup().getParent().list();
	}
}
