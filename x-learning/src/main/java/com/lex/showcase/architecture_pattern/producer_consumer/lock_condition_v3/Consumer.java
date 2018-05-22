package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition_v3;


import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 基于Java并发包中lock-condition的生产者/消费者模型
 */
public class Consumer extends Thread {
    private MyService myService;

    public Consumer(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.consume();
    }
}
