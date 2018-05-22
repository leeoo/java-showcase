package com.lex.showcase.algorithm.basic;

/**
 * 非线程安全的栈
 * 栈是最简单的链式数据结构
 * @param <E>
 */
public class Stack<E> {
    private Node<E> top; // 栈顶

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        System.out.println(stringStack.pop());
        stringStack.push("Hello");
        System.out.println(stringStack.pop());
    }

    public void push(E e) {
        Node<E> oldHead = top;
        Node<E> newHead = new Node(e);
        newHead.next = oldHead;
        top = newHead;
    }

    public E pop() {
        Node<E> oldHead = top;
        Node<E> newHead;
        if (oldHead == null) {
            return null;
        }
        newHead = oldHead.next;
        top = newHead;
        return oldHead.item;
    }

    /**
     * 套路1：私有静态内部类 //
     * @param <E>
     */
    private static class Node<E> {
        public final E item; // 套路2：公共final修饰的成员
        public Node<E> next; // 套路3：公共修饰的成员

        Node(E item) {
            this.item = item;
        }
    }
}
