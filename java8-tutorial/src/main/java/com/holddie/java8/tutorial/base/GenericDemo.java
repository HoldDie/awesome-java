package com.holddie.java8.tutorial.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDemo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		Class clazz = demo.getClass();
		System.out.println("clazz.getSuperclass(): " + clazz.getSuperclass());

		Type type = clazz.getGenericSuperclass();
		System.out.println("type: " + type);

		ParameterizedType p = (ParameterizedType) type;
		Class c = (Class) p.getActualTypeArguments()[0];
		System.out.println("p.getActualTypeArguments()[0]: " + c);
	}

	public static class Person<T> {
	}

	public static class Demo extends Person<GenericDemo> {
	}
}


