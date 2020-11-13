package com.holddie.jvm.oom;

/**
 * 创建线程导致内存溢出异常
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/10/20 7:20 PM
 */
public class JavaVMStackSOFV3 {

	private void dontStop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			new Thread(this::dontStop).start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackSOFV3 stackSOFV3 = new JavaVMStackSOFV3();
		stackSOFV3.stackLeakByThread();
	}

}
