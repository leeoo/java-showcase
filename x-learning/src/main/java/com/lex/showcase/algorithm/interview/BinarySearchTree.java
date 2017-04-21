package com.lex.showcase.algorithm.interview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private static Logger log = LogManager.getLogger(BinarySearchTree.class);

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value min() {
        return min(root);
    }
    private Value min(Node x) {
        if (x.left == null) return x.value;
        return min(x.left);
    }

    public Value max() {
        return max(root);
    }
    private Value max(Node x) {
        if (x.right == null) return x.value;
        return max(x.right);
    }


    public static void main(String[] args) {
        Integer[] a = {3, 1, 4, 5, 9, 2, 6};

        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        log.info(tree.size());
        for (Integer i : a) {
            tree.put(i, i);
        }

        int max = tree.max();
        int min = tree.min();

        log.info("max: " + max + ", min: " + min);
        int diff = max - min;
        log.info("Diff between max and min is " + diff);
    }
}
