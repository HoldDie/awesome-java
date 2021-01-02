package com.holddie.java8.tutorial.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Data
public class ForeachDemo {
	private int x = 1;

	public static void main(String[] args) {
		ForeachDemo foreachDemo = new ForeachDemo();
		foreachDemo.test();
		System.out.println("最终结果：" + foreachDemo.x);
	}

	private void test() {
		List<Integer> list = Arrays.asList(1, 2);
		AtomicInteger y = new AtomicInteger(1);
		list.forEach(e -> {
			x = 2 + e;
			y.set(2 + e);
			System.out.println("inner: x->" + x + " y->" + y.get());
		});
	}
}
