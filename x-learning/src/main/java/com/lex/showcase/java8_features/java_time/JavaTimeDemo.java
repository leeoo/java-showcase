package com.lex.showcase.java8_features.java_time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;

/**
 *
 */
public class JavaTimeDemo {
    private static Logger log = LoggerFactory.getLogger(JavaTimeDemo.class);

    public static void main(String[] args) {
        Date day1 = new Date();
        Instant instant = day1.toInstant();
        log.info("day1: {}", day1);
        log.info("instant: {}", instant);
    }
}
