package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于Java并发包中lock-condition的生产者/消费者模型
 */
public class Producer extends Thread {

    private Queue<Integer> queue;
    private Lock lock;

    public Producer(Queue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        Condition condition = lock.newCondition();
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                // Waiting until queue is not full!
                while (queue.size() == 5) {
                    System.out.println("Queue is full, waiting...");
                    condition.await();
                }
                queue.add(i);
                System.out.println("Produced " + i);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
