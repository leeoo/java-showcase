package com.lex.showcase.multiple_datasource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author Lex Li
 */
public class AccountServiceImplTest extends BaseTest {

    @Resource
    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadAccountsWithPaging() throws Exception {
    }

    @Test
    public void loadAccount() throws Exception {
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

}