package com.lex.showcase.algorithm.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 无锁的并发栈，使用AtomicReference和CAS实现。
 */
public class ConcurrentStack<E> {
    private AtomicReference<Node<E>> top = new AtomicReference<>();

    public static void main(String[] args) {
        ConcurrentStack<Integer> stack = new ConcurrentStack<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        calc(stack);
                    }
                });
            }
        } finally {
            executorService.shutdown();
        }
    }

    private static void calc(ConcurrentStack<Integer> stack) {
        for (int i = 0; i < 10000; i++) {
            System.out.println(stack.pop());
            stack.push(i);
            System.out.println(String.format("%s, pop value: %s", Thread.currentThread(), stack.pop()));
        }
    }

    public void push(E e) {
        Node<E> oldHead = top.get();
        Node<E> newHead;
        do {
            newHead = new Node(e);
            newHead.next = oldHead;
        } while (top.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead = top.get();
        Node<E> newHead;
        if (oldHead == null) {
            return null;
        }
        do {
            newHead = oldHead.next;
        } while (top.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }


    private static class Node<E> {
        public final E item;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }
}
