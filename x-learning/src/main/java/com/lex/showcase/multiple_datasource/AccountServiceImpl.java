package com.lex.showcase.multiple_datasource;

import com.alibaba.fastjson.JSON;
import com.lex.showcase.common.util.PagingQuery;
import com.lex.showcase.common.util.PagingQueryImpl;
import com.lex.showcase.mybatis.mapper.AccountGroupMapper;
import com.lex.showcase.mybatis.mapper.AccountMapper;
import com.lex.showcase.mybatis.model.Account;
import com.lex.showcase.mybatis.model.AccountGroup;
import com.lex.showcase.mybatis.vo.UserReq;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lex Li
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountGroupMapper accountGroupMapper;

    @Override
    public PagingQuery<AccountRes> loadAccountsWithPaging(UserReq request) {
        if (request == null) {
            log.error("Request cannot be null! request = {}", JSON.toJSONString(request));
        }
        Account condition = new Account();
        condition.setId(request.getId());
        condition.setUsername(request.getName());
        List<Account> accountList = accountMapper.selectBySelective(condition);

        if (CollectionUtils.isEmpty(accountList)) {
            log.info("No accounts found!");
//            return new Result<>();
            return new PagingQueryImpl<>();
        }

        List<AccountRes> responseDataList = new ArrayList<>();
        List<Integer> accountGroupIds = accountList.stream()
                .filter(e -> e.getAccountGroupId() != null)
                .map(Account::getAccountGroupId)
                .distinct().collect(Collectors.toList());
        Map<Integer, List<AccountGroup>> accountGroupMap = new HashMap<>();
        if (CollectionUtils.isEmpty(accountGroupIds)) {
            List<AccountGroup> accountGroups = accountGroupMapper.findByIds(accountGroupIds);
            // TODO
            accountGroupMap = accountGroups.stream().collect(Collectors.groupingBy(AccountGroup::getId));
        }

        for (Account account : accountList) {
            AccountRes res = new AccountRes();
            res.setId(account.getId());
            res.setName(account.getUsername());
            res.setAccount(account);
            List<AccountGroup> accountGroups = accountGroupMap.get(account.getAccountGroupId());
            res.setAccountGroup(CollectionUtils.isNotEmpty(accountGroups) ? accountGroups.get(0) : null);
        }

        return new PagingQueryImpl<>(responseDataList);
    }

//    @DataSource(DataSourcePolicy.SLAVE)
    @Override
    public Account loadAccount(Account account) {
        log.info("Load account by {}", JSON.toJSONString(account));
        return accountMapper.selectByPrimaryKey(account.getId());
    }
}
