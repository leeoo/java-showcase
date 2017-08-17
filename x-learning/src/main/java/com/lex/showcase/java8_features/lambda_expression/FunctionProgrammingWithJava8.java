package com.lex.showcase.java8_features.lambda_expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class FunctionProgrammingWithJava8 {
    private static Logger log = LoggerFactory.getLogger(FunctionProgrammingWithJava8.class);

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        integerList.forEach((Integer i) -> System.out.println(i));

        integerList.sort((Integer i, Integer j) -> i.compareTo(j));
        log.info("After sorting: {}", integerList);
    }
}
