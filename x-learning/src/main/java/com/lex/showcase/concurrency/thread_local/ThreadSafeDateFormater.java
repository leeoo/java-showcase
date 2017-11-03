package com.lex.showcase.concurrency.thread_local;

import com.lex.showcase.common.util.DateUtils2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lex Li
 */
public class ThreadSafeDateFormater {

    private static final String ISO8601_DATETIME_WITH_MILLS = "yyyyMMdd";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(ISO8601_DATETIME_WITH_MILLS);

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        for (int i = 0; i < 1000000000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
//                        try {
//                            Thread.sleep(200);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        Date date = SIMPLE_DATE_FORMAT.parse("20171011");
//                        System.out.println(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();


//        Date today = new Date();
//        String dateString = DateUtils2.format(today);
//        System.out.println(dateString);
//
//        dateString = DateUtils2.format(today, ISO8601_DATETIME_WITH_MILLS);
//        System.out.println(dateString);
//
//        dateString = DateUtils2.format(today, "yyyy.MM.dd");
//        System.out.println(dateString);
    }
}
