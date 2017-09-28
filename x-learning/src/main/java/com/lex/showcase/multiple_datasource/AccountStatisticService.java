package com.lex.showcase.multiple_datasource;

import com.lex.showcase.common.util.PagingQuery;
import com.lex.showcase.multiple_datasource.datasource.DataSource;
import com.lex.showcase.multiple_datasource.datasource.DataSourcePolicy;
import com.lex.showcase.mybatis.model.Account;
import com.lex.showcase.mybatis.vo.UserReq;

/**
 * 账户相关统计查询 （全部走从库）
 * @author Lex Li
 */
public interface AccountStatisticService {

    @DataSource(value = DataSourcePolicy.SLAVE)
    PagingQuery<AccountRes> getAccountUseStatistic(UserReq request);

    @DataSource(value = DataSourcePolicy.SLAVE)
    PagingQuery<AccountRes> getAccountGroupUseStatistic(UserReq request);
//    PagingQuery<AccountGroupRes> getAccountGroupUseStatistic(UserReq request);
}
