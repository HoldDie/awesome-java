package com.holddie.jvm.gc;

/**
 * VM Args: -XX:+PrintGCDetails
 * <p>
 * 引用计数法，gc 时，还是不能很好 gc
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/10/25 4:35 PM
 */
public class ReferenceCountingGC {

	public Object instance = null;
	private static final int _1MB = 1024 * 1024;

	private byte[] bigSize = new byte[2 * _1MB];

	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		System.gc();
	}

	public static void main(String[] args) {
		testGC();
	}
}
