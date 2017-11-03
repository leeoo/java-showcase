package com.lex.showcase.concurrency.wait_notify;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Lex Li
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
//        ThreadFactory threadFactory = new ThreadFactory();
        ThreadPoolExecutor singleThreadPoolExecutor = new ThreadPoolExecutor(1, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), new ThreadPoolExecutor.AbortPolicy());
        singleThreadPoolExecutor.execute(() -> System.out.println(String.format("%s, test", Thread.currentThread().getName())));
        singleThreadPoolExecutor.shutdown();
    }

}
