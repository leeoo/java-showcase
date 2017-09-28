package com.lex.showcase.multiple_datasource;

import com.alibaba.fastjson.JSON;
import com.lex.showcase.multiple_datasource.datasource.DataSource;
import com.lex.showcase.multiple_datasource.datasource.DataSourcePolicy;
import com.lex.showcase.mybatis.mapper.AccountGroupMapper;
import com.lex.showcase.mybatis.mapper.AccountMapper;
import com.lex.showcase.mybatis.model.AccountGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lex Li
 */
@Service("accountGroupService")
public class AccountGroupServiceImpl implements AccountGroupService {

    private static Logger log = LoggerFactory.getLogger(AccountGroupServiceImpl.class);

    @Resource
    private AccountGroupMapper accountGroupMapper;

    @Override
    public List<AccountGroup> loadAccountGroupsWithPaging() {
        return null;
    }

    @DataSource(DataSourcePolicy.SLAVE)
    @Override
    public AccountGroup loadAccountGroup(AccountGroup accountGroup) {
        log.info("Load account group by {}", JSON.toJSONString(accountGroup));
        return accountGroupMapper.selectByPrimaryKey(accountGroup.getId());
    }
}
