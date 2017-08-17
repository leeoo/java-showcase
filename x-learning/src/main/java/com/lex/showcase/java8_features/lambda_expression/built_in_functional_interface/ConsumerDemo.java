package com.lex.showcase.java8_features.lambda_expression.built_in_functional_interface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo<T> {
    private static Logger log = LoggerFactory.getLogger(ConsumerDemo.class);

    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> log.info("{}", i));
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
