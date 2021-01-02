package com.holddie.java.base;

public class Runner2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
//			System.out.println("进入 Runner2 运行状态-" + i);
		}
		boolean interrupted = Thread.currentThread().isInterrupted();
		boolean interrupted1 = Thread.interrupted();
		boolean interrupted2 = Thread.currentThread().isInterrupted();
		
		System.out.println("Runner2.run interrupted ====>" + interrupted);
		System.out.println("Runner2.run interrupted1 ====>" + interrupted1);
		System.out.println("Runner2.run interrupted2 ====>" + interrupted2);
	}
}
