package com.lex.showcase.common.util;

/**
 * @author Lex Li
 */
public class PagingQueryObject {
    private int pageNo;
    private int pageSize;
    private int offset;

    public PagingQueryObject() {

    }

    public PagingQueryObject(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void calculateOffset() {
        if (pageNo < 1 || pageSize < 1) {
            this.offset = 0;
        }

        this.offset = (pageNo - 1) * pageSize;
    }
}
