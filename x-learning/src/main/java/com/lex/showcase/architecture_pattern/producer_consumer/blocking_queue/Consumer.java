package com.lex.showcase.architecture_pattern.producer_consumer.blocking_queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于阻塞队列的消费者的生产者/消费者模型
 */
public class Consumer extends Thread {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer num = queue.take();
                System.out.println("Consumed! data=" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
