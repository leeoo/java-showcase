package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition_v2;


import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 基于Java并发包中lock-condition的生产者/消费者模型
 */
public class Consumer extends Thread {
    private CacheQueue<Integer> queue;
    private Lock lock;

    public Consumer(CacheQueue<Integer> queue) {
        this.queue = queue;
        this.lock = queue.getLock();
    }

    public Consumer(CacheQueue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        Condition empty = queue.getEmpty();
        Condition full = queue.getFull();

        while (true) {
            try {
                lock.lock();
                // Waiting until queue is not empty!
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty, waiting...");
                    full.signalAll();
                    empty.await();
                }
                Integer num = queue.take();
                System.out.println("Consumed " + num);

                // termination condition
//            if (num == 4) {
//                return;
//            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
