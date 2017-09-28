package com.lex.showcase.multiple_datasource;

import com.lex.showcase.mybatis.model.Account;

import java.util.List;

/**
 * @author Lex Li
 */
public interface AccountAdminService {
    List<AccountRes> getAccounts(Account account);
}
