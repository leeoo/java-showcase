package com.lex.showcase.architecture_pattern.producer_consumer.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于阻塞队列的生产者的生产者/消费者模型
 */
public class Producer extends Thread {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                queue.put(i);
                System.out.println("Produced! data=" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
