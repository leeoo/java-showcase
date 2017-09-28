package com.lex.showcase.multiple_datasource;

import com.alibaba.fastjson.JSON;
import com.lex.showcase.mybatis.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Lex Li
 */
public class AccountAdminServiceImplTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger(AccountAdminServiceImplTest.class);

    @Resource
    private AccountAdminService accountAdminService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccounts() throws Exception {
        Account queryObj = new Account();
        queryObj.setId(1);
        List<AccountRes> result = accountAdminService.getAccounts(queryObj);
        log.info("{}", JSON.toJSONString(result));
    }

}