package com.lex.showcase.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找法，折半查找法
 */
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.addAll(Arrays.asList(9, 8, 3, 7, 21, 0, 4, 1));
        Collections.sort(numberList);
        System.out.println("Given sorted number list: " + numberList);

//        for (int i = 0; i < numberList.size(); i++) {
//
//        }
        int numToFind = 7;
        int mid = numberList.size() / 2;
        while (numToFind < numberList.get(mid)) {

        }
    }


}
