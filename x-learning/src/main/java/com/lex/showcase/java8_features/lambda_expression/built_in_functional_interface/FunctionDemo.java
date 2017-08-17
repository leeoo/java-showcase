package com.lex.showcase.java8_features.lambda_expression.built_in_functional_interface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    private static Logger log = LoggerFactory.getLogger(FunctionDemo.class);

    public static void main(String[] args) {
        List<Integer> lengths = map(Arrays.asList("I", "am", "feeling", "good"), (String word) -> word.length());
        log.info("Lengths: {}", lengths);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R r = f.apply(t);
            result.add(r);
        }
        return result;
    }
}
