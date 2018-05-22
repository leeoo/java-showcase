package com.lex.showcase.algorithm.basic;

import java.util.Arrays;

/**
 * 冒泡排序是稳定的排序，但是算法复杂度较高，平均和最差都是：O(n^2)，空间复杂度为：O(1)
 */
public class BubbleSorter {

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 5, 9, 2, 6};
        System.out.println("Before sorting: " + Arrays.toString(a));

        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        System.out.println("After sorting: " + Arrays.toString(a));
    }
}
