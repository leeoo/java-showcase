package com.lex.showcase.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lex Li
 */
public class DateUtils2 {

    // TODO 默认两种ISO8601格式化形式，其他格式化形式（如 yyyyMMdd, yyyyMMddHHmmss）提供接口由用户指定传入
    private static final String ISO8601_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String ISO8601_DATE = "yyyy-MM-dd";

    private static ThreadLocal<SimpleDateFormat> dateFormatterThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(ISO8601_DATETIME);
        }
    };


    private static void setPattern(String pattern) {
        if (pattern == null || pattern.trim().length() == 0) {
            return;
        }

        dateFormatterThreadLocal.get().applyPattern(pattern);
    }

    public static String format(Date date) {
        return format(date, null);
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }

        setPattern(pattern);
        return dateFormatterThreadLocal.get().format(date);
    }

    public static Date parse(String value) {
        return parse(value, null);
    }

    public static Date parse(String value, String pattern) {
        if (value == null || value.trim().length() == 0) {
            return null;
        }
        setPattern(pattern);
        try {
            return dateFormatterThreadLocal.get().parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse string to value!", e);
        }
    }

    public static Date startOfDay(Date date) {
        return null; // TODO
    }
}
