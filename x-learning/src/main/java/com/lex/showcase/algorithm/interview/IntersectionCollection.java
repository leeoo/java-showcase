package com.lex.showcase.algorithm.interview;

import java.util.*;

/**
 * 求两个整数集合的交集
 */
public class IntersectionCollection {
    public static void main(String[] args) {
        int[] a1 = {3, 1, 2, 4, 5, 8, 7};
        int[] a2 = {9, 3, 0, 1, 6, 7, 5};

        // 方案一：将其中一个集合转换成哈希表，然后查找
        Map<Integer, Integer> a1map = new HashMap<>();
        for (int e : a1) {
            a1map.put(e, e);
        }

        // 交集
        List<Integer> intersection = new ArrayList<>();

        for (int e : a2) {
            if (a1map.get(e) != null) {
                intersection.add(e);
            }
        }

        System.out.println(String.format("集合%s和集合%s的交集为：%s", Arrays.toString(a1), Arrays.toString(a2), Arrays.asList(intersection)));

        // 方案2：对两个集合做循环
        intersection.clear(); // 重用前面的列表
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    intersection.add(a1[i]);
                    break;
                }
            }
        }
        System.out.println(String.format("集合%s和集合%s的交集为：%s", Arrays.toString(a1), Arrays.toString(a2), Arrays.asList(intersection)));

        // 方案3：先将两个集合分别从小到大排序，找到每个集合的MIN和MAX
        // 若a1.MIN > a2.MAX || a1.MAX < a2.MIN，则两个集合不相交，返回空集。
        // 否则

    }
}
