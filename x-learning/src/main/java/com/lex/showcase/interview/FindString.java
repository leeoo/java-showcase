package com.lex.showcase.interview;

/**
 */
public class FindString {

    public static int findStr(String strA, String strB) {
        if ((strA == null || strA.length() == 0) || (strB == null || strB.length() == 0)) {
            throw new IllegalArgumentException("Cannot process empty string!");
        }

        if (strA.contains(strB)) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String strA = "Hello";
        String strB = "el";
        System.out.println(findStr(strA, strB));
    }
}
