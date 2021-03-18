package com.holddie.java.error;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ErrorThread {

    void testThread1() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        MyThread myThread = new MyThread();
        myThread.start();
    }

    void testThread2() {
        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        myThread.start();
    }

    void testThread3() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyThread());
    }

    void testThread4() {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Thread::new, new ThreadPoolExecutor.AbortPolicy());
        myThreadPoolExecutor.execute(new MyThread());
    }

    void testThread5() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(new MyThread());
    }

    void testThread6() {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Thread::new, new ThreadPoolExecutor.AbortPolicy());
        myThreadPoolExecutor.submit(new MyThread());
    }

    void testRunnable1() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        new Thread(new MyRunnable()).start();
    }

    void testRunnable2() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();
    }

    void testRunnable3() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyRunnable());
    }

    void testRunnable4() {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Thread::new, new ThreadPoolExecutor.AbortPolicy());
        myThreadPoolExecutor.execute(new MyRunnable());
    }

    void testRunnable5() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(new MyThread());
    }

    void testRunnable6() {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Thread::new, new ThreadPoolExecutor.AbortPolicy());
        myThreadPoolExecutor.submit(new MyRunnable());
    }

    void testCallable1() {
        MyCallable myCallable = new MyCallable();
        FutureTask<Object> objectFutureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(objectFutureTask);
        thread.start();
        try {
            objectFutureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("callable thread occur exception", e.getCause());
        }
    }

    void testCallable2() {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5, 50, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Thread::new, new ThreadPoolExecutor.AbortPolicy());
        myThreadPoolExecutor.submit(new MyCallable());
    }

    public static void main(String[] args) {
        /**
         * https://cdn.jsdelivr.net/gh/asxing/img1/20210318150430.png
         */
        ErrorThread errorThread = new ErrorThread();
        errorThread.testThread1();
        errorThread.testThread2();
        errorThread.testThread3();
        errorThread.testThread4();
        errorThread.testThread5();
        errorThread.testThread6();
        errorThread.testRunnable1();
        errorThread.testRunnable2();
        errorThread.testRunnable3();
        errorThread.testRunnable4();
        errorThread.testRunnable5();
        errorThread.testRunnable6();
        errorThread.testCallable1();
        errorThread.testCallable2();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int a = 1 / 0;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        int a = 1 / 0;
    }
}

class MyCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        return 1 / 0;
    }
}

@Slf4j
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.info("thread [{}] occur exception", t.getName(), e);
    }
}

@Slf4j
class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                Object object = ((Future<?>) r).get();
            } catch (CancellationException e) {
                t = e;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                t = e.getCause();
            }
        }
        if (t != null) {
            log.error("async-thread occur exception", t);
        }
    }
}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
}