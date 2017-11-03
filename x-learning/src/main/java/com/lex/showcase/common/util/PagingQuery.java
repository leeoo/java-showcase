package com.lex.showcase.common.util;

import java.util.List;

/**
 * @author Lex Li
 */
public interface PagingQuery<T> {
    List<T> getDataList();

    int getPageNo();
    void setPageNo(int pageNo);

    int getPageSize();
    void setPageSize(int pageSize);

    int getTotalCount();
    void setTotalCount(int totalCount);

    /**
     * 计算分页查询偏移量，计算公式：(pageNo - 1) * pageSize
     * @return
     */
    void calculatePagingOffset();
}
