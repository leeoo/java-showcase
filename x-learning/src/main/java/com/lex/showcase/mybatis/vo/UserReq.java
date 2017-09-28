package com.lex.showcase.mybatis.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * User request object with pagination for query.
 * @author Lex Li
 */
public class UserReq {
    private Integer id;
    private String name;
    private String loginName;

    private int pageNo = 1; // 起始页码为1.

    private int pageSize = 20; // Default value is 20 for data size each page.

    /**
     * 对于弱鸡MySQL，由于其执行SQL时不支持在分页查询语句中进行算术运算操作，
     * 可在MyBatis的mapper xml文件中使用<bind/>标签作计算，亦可在当前类中计算或者在PagingHelper中计算。
     */
    private int offset; // 起始偏移量为0而不是1，其值计算方法为：(pageNo - 1) * pageSize

    public UserReq() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("loginName", loginName)
                .append("pageNo", pageNo)
                .append("pageSize", pageSize)
                .append("offset", offset)
                .toString();
    }
}
