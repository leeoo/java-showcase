package com.lex.showcase.multiple_datasource;

import com.lex.showcase.mybatis.model.Account;
import com.lex.showcase.mybatis.model.AccountGroup;

/**
 * 账户查询Response对象
 */
public class AccountRes {

    private Integer id;
    private String name;

    private Account account;
    private AccountGroup accountGroup;

    // 总页数、总数据量
    private long totalPage;
    private long totalCount;

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


    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }
}
