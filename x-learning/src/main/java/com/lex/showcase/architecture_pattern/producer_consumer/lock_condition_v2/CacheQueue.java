package com.lex.showcase.architecture_pattern.producer_consumer.lock_condition_v2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CacheQueue<T> {
    private volatile int capacity;

    private Queue<T> queue;

    private Lock lock;

    private Condition empty;
    private Condition full;

    public CacheQueue(int capacity, Lock lock) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue capacity must be greater than 0!");
        }
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.lock = lock;

        // init conditions
        this.empty = lock.newCondition();
        this.full = lock.newCondition();
    }

    public Condition getEmpty() {
        return empty;
    }

    public void setEmpty(Condition empty) {
        this.empty = empty;
    }

    public Condition getFull() {
        return full;
    }

    public void setFull(Condition full) {
        this.full = full;
    }



    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized boolean isFull() {
        return queue.size() == capacity;
    }

    public void put(T t) {
        queue.add(t);
    }

    public T take() {
        return queue.poll();
    }

    public Lock getLock() {
        return lock;
    }
}
