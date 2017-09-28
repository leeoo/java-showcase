package com.lex.showcase.multiple_datasource;

import com.lex.showcase.mybatis.model.AccountGroup;

import java.util.List;

/**
 * @author Lex Li
 */
public interface AccountGroupService {
    List<AccountGroup> loadAccountGroupsWithPaging();

    AccountGroup loadAccountGroup(AccountGroup accountGroup);
}
