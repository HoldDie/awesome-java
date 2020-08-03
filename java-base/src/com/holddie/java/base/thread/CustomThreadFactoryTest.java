package com.holddie.java.base.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomThreadFactoryTest {

	private CustomThreadFactory customThreadFactoryUnderTest;

	@BeforeEach
	void setUp() {
		customThreadFactoryUnderTest = new CustomThreadFactory("name");
	}

	@Test
	void testNewThread() {
		// Setup
		Task task = new Task();
		Thread thread;
		System.out.println("Starting the Threads");
		for (int i = 0; i < 10; i++) {
			thread = customThreadFactoryUnderTest.newThread(task);
			thread.start();
		}
		System.out.println("ALl Threads are created now");
		System.out.println("Give me CustomThreadFactory states: \n" + customThreadFactoryUnderTest.getStates());

	}


}
