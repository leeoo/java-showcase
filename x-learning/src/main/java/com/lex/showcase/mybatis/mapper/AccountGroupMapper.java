package com.lex.showcase.mybatis.mapper;

import com.lex.showcase.mybatis.model.AccountGroup;

public interface AccountGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountGroup record);

    int insertSelective(AccountGroup record);

    AccountGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountGroup record);

    int updateByPrimaryKey(AccountGroup record);
}