package com.lex.showcase.concurrency.wait_notify;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Lex Li
 */
public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        int availableProcesses = Runtime.getRuntime().availableProcessors();
        System.out.println(String.format("There are %s CPU cores!", availableProcesses));
//        demoConcurrentWithOldMode(counter, availableProcesses);
//        counter.reset();
        demoConcurrentWithNewMode(counter, availableProcesses);
    }

    /**
     * 使用自定义线程池的方式演示并发操作（推荐！）
     */
    private static void demoConcurrentWithNewMode(Counter counter, int availableProcesses) {
        ThreadPoolExecutor fixedThreadPoolExecutor = new ThreadPoolExecutor(availableProcesses, availableProcesses,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
                new ThreadPoolExecutor.AbortPolicy());
        for (int j = 0; j < 20; j++) {
            fixedThreadPoolExecutor.execute(() -> {
                doWork(counter);
            });
        }
        fixedThreadPoolExecutor.shutdown();
    }

    /**
     * 使用显式创建线程的方式演示并发操作（不推荐！）
     */
    private static void demoConcurrentWithOldMode(Counter counter, int availableProcesses) {
        for (int i = 0; i < availableProcesses; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        doWork(counter);
                    }
                }
            });
            thread.start();
        }
    }

    private synchronized static void doWork(Counter counter) {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int number = counter.increment();
        System.out.println(String.format("%s, number -> %s", Thread.currentThread().getName(),
                number));
    }
}
