package com.holddie.java8.tutorial.base;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

@Data
public class A {
	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "A{" +
				"age=" + age +
				'}';
	}
}
