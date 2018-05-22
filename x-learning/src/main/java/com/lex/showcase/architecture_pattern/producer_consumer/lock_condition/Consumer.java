package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition;


import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 基于Java并发包中lock-condition的生产者/消费者模型
 */
public class Consumer extends Thread {
    private Queue<Integer> queue;
    private Lock lock;

    public Consumer(Queue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        Condition condition = lock.newCondition();

        try {
            lock.lock();
            // Waiting until queue is not empty!
            while (queue.isEmpty()) {
                System.out.println("Queue is empty, waiting...");
                condition.await();
            }
            Integer num = queue.poll();
            System.out.println("Consumed " + num);
            condition.signalAll();

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
