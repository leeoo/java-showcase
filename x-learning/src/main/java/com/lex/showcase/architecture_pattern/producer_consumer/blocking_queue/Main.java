package com.lex.showcase.architecture_pattern.producer_consumer.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用java并发包中的有界阻塞队列来实现生产者-消费者模式
 */
public class Main {

    public static void main(String[] args) {
        // TODO
        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(5); // 有界队列
//        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(); // 是否有界是可选的，既可做有界队列，又可做无界队列

        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}
