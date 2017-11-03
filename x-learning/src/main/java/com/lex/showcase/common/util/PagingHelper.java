package com.lex.showcase.common.util;

/**
 * 可以参考 Spring-Batch 的PagingQueryProvider接口、SqlPagingQueryUtils类
 */
public class PagingHelper {

    public static <T extends PagingQuery> void calculatePagingOffset(T t) {
//        PagingQuery pagingQuery = pagingQuery.
        t.calculatePagingOffset();
    }
}
