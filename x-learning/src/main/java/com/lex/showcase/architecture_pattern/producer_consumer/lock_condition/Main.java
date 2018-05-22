package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 基于Java并发包中lock-condition的生产者/消费者模型
 */
public class Main {

    public static void main(String[] args) {
        final int capacity = 5; // 指定缓冲区大小
        Queue<Integer> sharedQueue = new LinkedList<Integer>();
        Lock lock = new ReentrantLock();
        Producer producer = new Producer(sharedQueue, lock);
        Consumer consumer = new Consumer(sharedQueue, lock);
        producer.start();
        consumer.start();
    }

}
