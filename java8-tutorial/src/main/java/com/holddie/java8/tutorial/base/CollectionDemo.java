package com.holddie.java8.tutorial.base;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CollectionDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 2, 1, 3, 5, 4, 5, 8, 9, 6);
		print(list);

		Collections.sort(list);
		print(list);

		Collections.reverse(list);
		print(list);

		Collections.shuffle(list);
		print(list);

		System.out.println(Collections.frequency(list, 2));
		System.out.println("最大一个：" + Collections.max(list));

		Collections.fill(list, 8);
		print(list);

		list = Collections.singletonList(6);
		print(list);
	}

	private static void print(List<Integer> list) {
		System.out.println(String.join(",",
				list.stream()
						.map(Object::toString)
						.collect(Collectors.toList())
						.toArray(new String[]{})));
	}
}
