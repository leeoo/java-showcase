package com.lex.showcase.mybatis.mapper;

import com.lex.showcase.mybatis.model.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectBySelective(Account condition);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}