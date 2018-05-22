package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition_v2;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于Java并发包中lock-condition的生产者/消费者模型
 */
public class Producer extends Thread {

    private CacheQueue<Integer> queue;
    private Lock lock;

    private static final int TASKS = 10;

    private AtomicLong counter = new AtomicLong(1);

    public Producer(CacheQueue<Integer> queue) {
        this.queue = queue;
        this.lock = queue.getLock();
    }

    public Producer(CacheQueue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        Condition empty = queue.getEmpty();
        Condition full = queue.getFull();

//        while (true) {
            try {
                lock.lock();
                for (int i = 0; i < TASKS; i++) { // 假定总生产量为10
                    // Waiting until queue is not full!
                    if (queue.isFull()) {
                        System.out.println("Queue is full, waiting...");
                        empty.signalAll();
                        full.await();
                    }
                    queue.put(i);
                    System.out.println("Produced " + i);
                    // Termination condition
                    if (counter.incrementAndGet() >= TASKS) {
                        System.out.println("计数啦" + counter.get());
                        Thread.sleep(1500);
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
//    }
}
