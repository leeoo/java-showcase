package com.lex.showcase.multiple_datasource;

import com.lex.showcase.mybatis.model.Account;
import com.lex.showcase.mybatis.model.AccountGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lex Li
 */
@Service("accountAdminService")
public class AccountAdminServiceImpl implements AccountAdminService {
    private static Logger log = LoggerFactory.getLogger(AccountAdminServiceImpl.class);

    @Resource
    private AccountService accountService;

    @Resource
    private AccountGroupService accountGroupService;

    @Override
    public List<AccountRes> getAccounts(Account account) {
        if (account == null) {
            return Collections.emptyList();
        }

        AccountRes accountRes = new AccountRes();

        Account persistedAccount = accountService.loadAccount(account);
        accountRes.setAccount(persistedAccount);

        if (persistedAccount != null) {
            AccountGroup accountGroupQueryObj = new AccountGroup();
            accountGroupQueryObj.setId(persistedAccount.getAccountGroupId());
            AccountGroup accountGroup = accountGroupService.loadAccountGroup(accountGroupQueryObj);

            accountRes.setAccountGroup(accountGroup);
        }

        List<AccountRes> result = new ArrayList<>();
        result.add(accountRes);

        return result;
    }
}
