package com.holddie.java.base.thread;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


class PreStartThreadTest {

	private Logger log = LoggerFactory.getLogger(PreStartThreadTest.class);

	@Test
	public void testPreStartThread() {
		ThreadFactory customThreadFactory = new CustomThreadFactory("PreStartThreadTest");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				2,
				5,
				1L,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(5),
				customThreadFactory,
				new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化所有核心线程
		executor.prestartAllCoreThreads();
		// 初始化一个核心线程
//		executor.prestartCoreThread();
		AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0; i < 14; i++) {
			executor.execute(() -> log.warn(String.valueOf(atomicInteger.getAndIncrement())));
		}
		System.out.println("");
	}

	@Test
	public void testAllowCoreThreadTimeOut() {
		ThreadFactory customThreadFactory = new CustomThreadFactory("PreStartThreadTest");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				2,
				5,
				1L,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(5),
				customThreadFactory,
				new ThreadPoolExecutor.CallerRunsPolicy());
		// 允许核心线程自动清理
		executor.allowCoreThreadTimeOut(true);
		AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0; i < 14; i++) {
			executor.execute(() -> log.warn(String.valueOf(atomicInteger.getAndIncrement())));
		}
		System.out.println("");
	}
}
