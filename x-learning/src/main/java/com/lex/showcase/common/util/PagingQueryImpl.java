package com.lex.showcase.common.util;

import java.util.List;

/**
 * @author Lex Li
 */
public class PagingQueryImpl<T> implements PagingQuery<T> {

    private List<T> dataList;
    private int pageNo;
    private int pageSize;
    private int offset;
    private int totalCount;

    public PagingQueryImpl() {

    }

    public PagingQueryImpl(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public void calculatePagingOffset() {
        /**
         * 根据当前pageNo和pageSize计算offset
         */
        if (pageNo < 1) {
            this.offset = 0;
        }
        this.offset = (pageNo - 1) * pageSize;
    }
}
