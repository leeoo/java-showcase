package com.lex.showcase.multiple_datasource;

import com.alibaba.fastjson.JSON;
import com.lex.showcase.mybatis.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author Lex Li
 */
public class AccountGroupServiceImplTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger(AccountGroupServiceImplTest.class);

    @Resource
    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadAccountGroupsWithPaging() throws Exception {
    }

    @Test
    public void loadAccountGroup() throws Exception {
        Account queryObj = new Account();
        queryObj.setId(1);
        Account account = accountService.loadAccount(queryObj);
        log.info("{}", JSON.toJSONString(account));
    }

}