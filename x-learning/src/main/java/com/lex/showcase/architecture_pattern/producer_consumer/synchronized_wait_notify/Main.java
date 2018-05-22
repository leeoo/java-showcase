package com.lex.showcase.architecture_pattern.producer_consumer.synchronized_wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}
