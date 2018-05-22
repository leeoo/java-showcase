package com.lex.showcase.architecture_pattern.producer_consumer.synchronized_wait_notify;


import java.util.Queue;

/**
 * 基于同步和wait-notify的生产者/消费者模型
 */
public class Consumer extends Thread {
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // Waiting until queue is not empty!
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    System.out.println("Queue is empty, waiting...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer num = queue.poll();
                System.out.println("Consumed " + num);
                queue.notify();

                // termination condition
                if (num == 4) {
                    break;
                }
            }
        }
    }
}
