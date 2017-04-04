package com.lex.showcase.algorithm.basic;

import java.util.Arrays;

/**
 * Created by Lex on 2016/11/8.
 */
public class BubbleSorter {

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 5, 9, 2, 6};
        System.out.println("Before sorting: " + Arrays.toString(a));

        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        System.out.println("After sorting: " + Arrays.toString(a));
    }
}
