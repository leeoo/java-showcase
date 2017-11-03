package com.lex.showcase.concurrency.wait_notify;

/**
 * @author Lex Li
 */
public class Counter {
    private int count = 0;

    public  int increment() {
        return ++count;
    }

    public synchronized int decrement() {
        return --count;
    }

    public int getCount() {
        return count;
    }

    public synchronized void reset() {
        this.count = 0;
    }
}
