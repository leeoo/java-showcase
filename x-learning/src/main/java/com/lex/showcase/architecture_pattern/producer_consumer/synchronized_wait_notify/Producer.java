package com.lex.showcase.architecture_pattern.producer_consumer.synchronized_wait_notify;

import java.util.Queue;

/**
 * 基于同步和wait-notify的生产者/消费者模型
 */
public class Producer extends Thread {

    private Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (queue) {
                // Waiting until queue is not full!
                while(queue.size() >= 1) {
                    System.out.println("Queue is full, waiting...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(i);
                System.out.println("Produced " + i);
                queue.notify();
            }
        }
    }
}
