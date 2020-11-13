package com.holddie.jvm.oom;

public class TeskXSS {
	/**
	 * 设置参数   方法循环调用次数
	 * 默认      --> 5174
	 * -Xss1m   --> 7118
	 * -Xss512k --> 3450
	 * -Xss256k --> 1605
	 * -Xss200k --> 1116
	 * -Xss128k --> Error: Could not create the Java Virtual Machine.
	 */
	private static long count = 0;

	public static void main(String[] args) {
		infinitelyRecursiveMethod(1);
	}

	public static void infinitelyRecursiveMethod(long a) {
		System.out.println("ThreadName: " + Thread.currentThread() + ", 累计执行了: " + count++ + "次");
		infinitelyRecursiveMethod(a);
	}
}
