package com.holddie.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args: -XX:PermSize=6M -XX:MaxPerSize=6M
 * env: jdk6
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/10/21 9:50 PM
 */
public class RuntimeConstantPoolOOMV1 {

	public static void main(String[] args) {
		// 使用 Set 保持常量池的引用，避免 Full GC回收常量池操作
		Set<String> set = new HashSet<>();
		// 在 short 范围内足以让 6MB 的 PermSize 产生 OOM
		short i = 1;
		while (true) {
			set.add(String.valueOf(i++).intern());
		}
	}
}
