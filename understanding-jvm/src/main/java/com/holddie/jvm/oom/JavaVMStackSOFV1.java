package com.holddie.jvm.oom;

/**
 * VM Args: -Xss128k --> The stack size specified is too small, Specify at least 160k
 * <p>
 * 通过设置 -Xss 参数来使 StackOverflow
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/10/20 2:55 PM
 */
public class JavaVMStackSOFV1 {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOFV1 oom = new JavaVMStackSOFV1();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}
	}
}
