package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition_v3;

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

        MyService myService = new MyService(sharedQueue, lock);

        Producer producer = new Producer(myService);
        Consumer consumer = new Consumer(myService);
        producer.start();
        consumer.start();
    }

}
