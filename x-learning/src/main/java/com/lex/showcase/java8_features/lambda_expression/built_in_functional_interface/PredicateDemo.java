package com.lex.showcase.java8_features.lambda_expression.built_in_functional_interface;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo<T> {
    private static Logger log = LoggerFactory.getLogger(PredicateDemo.class);

    public static void main(String[] args) {
        List<String> strings = filter(Arrays.asList("I", "am", "not", "ok"), (String word) -> !word.equalsIgnoreCase("not"));
        log.info("Strings: {}", strings);

        List<Integer> negativeNumbers = filter(Arrays.asList(1, 3, -5, 0, -1, 2), (Integer num) -> num < 0);
        log.info("Negative numbers: {}", negativeNumbers);

        User tom = new User("tom", 20);
        User ada = new User("ada", 20);

        List<User> users = new ArrayList<>();
        users.add(tom);
        users.add(ada);

        Map<String, User> userMap = new HashMap<>();
        users.stream().map(u -> userMap.put(u.getName(), u)).collect(Collectors.toList());
        log.info("list: {}", users);
        log.info("map: {}", userMap);

        String src = "401";
        String target = "501";

        String src2 = src.replaceFirst("4", "5");
        if (src2.equals(target)) {
            log.info("src:{}, src2:{}, target:{}", src, src2, target);
        }
    }

    static class User {
        private String name;
        private Integer age;

        User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("name", name)
                    .append("age", age)
                    .toString();
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
