package com.holddie.java8.tutorial;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierTest {
	public static void main(String[] args) {
		//① 使用Supplier接口实现方法,只有一个get方法，无参数，返回一个值
		Supplier<Integer> supplier = new Supplier<Integer>() {
			@Override
			public Integer get() {
				//返回一个随机值
				return new Random().nextInt();
			}
		};

		System.out.println(supplier.get());
		System.out.println("********************");

		//② 使用lambda表达式，
		supplier = () -> new Random().nextInt();
		System.out.println(supplier.get());
		System.out.println("********************");

		//③ 使用方法引用
		Supplier<Double> supplier2 = Math::random;
		System.out.println(supplier2.get());

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		//返回一个optional对象
		Optional<Integer> first = stream.filter(i -> i > 4)
				.findFirst();

		//optional对象有需要Supplier接口的方法
		//orElse，如果first中存在数，就返回这个数，如果不存在，就放回传入的数
		System.out.println(first.orElse(1));
		System.out.println(first.orElse(7));

		System.out.println("********************");

		Supplier<Integer> integerSupplier = new Supplier<Integer>() {
			@Override
			public Integer get() {
				//返回一个随机值
				return new Random().nextInt();
			}
		};

		//orElseGet，如果first中存在数，就返回这个数，如果不存在，就返回supplier返回的值
		System.out.println(first.orElseGet(integerSupplier));
	}
}
