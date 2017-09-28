package com.lex.showcase.multiple_datasource;

import com.lex.showcase.common.util.PagingQuery;
import com.lex.showcase.mybatis.model.Account;
import com.lex.showcase.mybatis.vo.UserReq;

import java.util.List;

/**
 * @author Lex Li
 */
public interface AccountService {
    PagingQuery<AccountRes> loadAccountsWithPaging(UserReq request);

    Account loadAccount(Account account);
}
