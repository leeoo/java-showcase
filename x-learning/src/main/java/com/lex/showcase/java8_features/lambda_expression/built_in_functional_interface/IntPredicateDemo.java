package com.lex.showcase.java8_features.lambda_expression.built_in_functional_interface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * IntPredicate函数式接口用于针对int原始类型的谓词操作处理，避免使用Predicate时的自动装箱。
 */
public class IntPredicateDemo {
    private static Logger log = LoggerFactory.getLogger(IntPredicateDemo.class);

    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        log.info("{} is even number? {}", 139, evenNumbers.test(139));
    }

//    public static <T> List<T> filter(List<T> list, IntPredicate ip) {
//        List<T> result = new ArrayList<>();
//        for (T t : list) {
//            ip.test(t);
//        }
//    }
}
