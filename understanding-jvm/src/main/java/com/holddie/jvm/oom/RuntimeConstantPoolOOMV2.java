package com.holddie.jvm.oom;

/**
 * env:jdk6 输出：false  false
 * env:jdk8 输出：true   false
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/10/21 9:55 PM
 */
public class RuntimeConstantPoolOOMV2 {

	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);

		String str3 = "ja" + "va";
		System.out.println(str3.intern() == str3);
	}

}
