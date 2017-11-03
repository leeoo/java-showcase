package com.lex.showcase.common.util;

/**
 * 账户查询Request对象
 */
public class AccountReq {
    private Long id;
    private String name;
    private String type;

    private PagingQueryObject paging;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PagingQueryObject getPaging() {
        return paging;
    }

    public void setPaging(PagingQueryObject paging) {
        this.paging = paging;
    }
}
