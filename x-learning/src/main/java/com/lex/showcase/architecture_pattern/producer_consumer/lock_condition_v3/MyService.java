package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition_v3;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyService {
    private Queue<Integer> queue;
    private Lock lock;
    private Condition condition;

    public MyService(Queue<Integer> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public void produce() {
        Random random = new Random();
        while (true) {
            try {
                lock.lock();
                while (queue.size() >= 1) {
                    condition.await();
                }
                int num = random.nextInt(100);
                queue.add(num);
                System.out.println("Produced: " + num);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void consume() {
        while (true) {
            try {
                lock.lock();
                while (queue.isEmpty()) {
                    condition.await();
                }
                Integer num = queue.poll();
                System.out.println("Consumed: " + num);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
