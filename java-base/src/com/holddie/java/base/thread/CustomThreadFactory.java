package com.holddie.java.base.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	private int counter;
	private String name;
	private List<String> states;

	public CustomThreadFactory(String name) {
		counter = 1;
		this.name = name;
		states = new ArrayList<>();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable, name + "-Thread_" + counter);
		counter++;
		states.add(String.format("Created thread %d with name %s on %s \n", thread.getId(), thread.getName(), new Date()));
		return thread;
	}

	public String getStates() {
		StringBuilder buffer = new StringBuilder();
		for (String state : states) {
			buffer.append(state);
		}
		return buffer.toString();
	}
}
