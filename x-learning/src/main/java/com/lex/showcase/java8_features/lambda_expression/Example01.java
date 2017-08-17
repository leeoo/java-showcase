package com.lex.showcase.java8_features.lambda_expression;

import java.util.*;

public class Example01 {

    public static void main(String[] args) {
        String[] array = {"Today", "is", "Monday"};
        System.out.println("Before sorting: " + Arrays.toString(array));
        String[] array2 = Arrays.copyOf(array, array.length);
        System.out.println("Before sorting, array2: " + Arrays.toString(array));
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("After sorting: " + Arrays.toString(array));

        execute();

        Runnable r = () -> {System.out.println("Runnable ...");};

        Comparator<String> comparator = (String x, String y) -> Integer.compare(x.length(),
                y.length());
        Arrays.sort(array2, comparator);
//        comparator = Comparator.comparingInt((x, y) -> x.length() > y.length());
    }

    public static void execute() {
        Object o = null;
        Objects.requireNonNull(o);

        List<String> filtered = new ArrayList<>();
        List<String> strings = Arrays.asList("H", "E", "Y");
//        filtered = strings.stream().forEach((String x) -> {
//            x.compareTo("X")
//        });
    }
}
