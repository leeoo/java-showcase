package com.lex.showcase.algorithm.basic;

import java.util.Arrays;

/**
 * Created by Lex on 2016/11/8.
 */
public class QuickSorting {

    public static int getMiddle(int[] a, int low, int high) {
        int key = a[low]; // 数组或集合的第1个数据作为中轴，即哨兵
        while (low < high) {
//            while (low < high && temp <= a[high]) {
            if (key <= a[high]) {
                high--;
            }
            a[low] = a[high]; // 比中轴小的数据移到低端
//            while (low < high && temp >= a[low]) {
            if (key >= a[low]) {
                low++;
            }
            a[high] = a[low]; // 比中轴大的数据移到高端
        }
        a[low] = key;
        return low;
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = getMiddle(a, low, high); // 将数组或集合一分为二
            quickSort(a, low, mid - 1); // 对低端表进行递归排序
            quickSort(a, mid + 1, high); // 对高端表进行递归排序
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Before sorting: " + Arrays.toString(a));
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
        System.out.println("After sorting: " + Arrays.toString(a));
    }
}
