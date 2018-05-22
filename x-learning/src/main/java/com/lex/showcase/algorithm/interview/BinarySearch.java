package com.lex.showcase.algorithm.interview;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5}; // 被查找的集合
        int key = 4; // 要查找的数

        int position = loop_find(a, key);
        System.out.println(String.format("循环查找法查找到关键字%s的位置为：%s", key, position));

        int position2 = recursion_find(0, a.length - 1, a, key);
        System.out.println(String.format("递归查找法查找到关键字%s的位置为：%s", key, position2));
    }

    /**
     * 循环查找法
     *
     * @param a
     * @param key
     * @return
     */
    private static int loop_find(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                // 往左找
                hi = mid - 1; // 中间位置的数大于查找关键字，则高位肯定要取中间位置的前1位！
            } else if (key > a[mid]) {
                // 往右找
                lo = mid + 1; // 中间位置的数小于查找关键字，则低位肯定要取中间位置的后1位！
            } else {
                // 找到！
                return mid;
            }
        }
        return -1; // 未找到！
    }

    /**
     * 递归查找法
     *
     * @param a
     * @param key
     * @return -1表示未找到，否则找到！
     */
    private static int recursion_find(int lo, int hi, int[] a, int key) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;
        if (key < a[mid]) {
            return recursion_find(lo, mid - 1, a, key);
        } else if (key > a[mid]) {
            return recursion_find(mid + 1, hi, a, key);
        } else {
            return mid;
        }
    }
}
