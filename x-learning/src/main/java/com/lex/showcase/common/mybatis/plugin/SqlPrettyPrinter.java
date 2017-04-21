package com.lex.showcase.common.mybatis.plugin;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts(value = {
		@Signature(type = StatementHandler.class, method = "query", args = { Statement.class, ResultHandler.class }),
		@Signature(type = StatementHandler.class, method = "update", args = { Statement.class }),
		// @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),
		// @Signature(type = StatementHandler.class, method = "parameterize", args = {Statement.class}),
		@Signature(type = StatementHandler.class, method = "batch", args = { Statement.class }) })
public class SqlPrettyPrinter implements Interceptor {

	private static Logger LOG = LoggerFactory.getLogger(SqlPrettyPrinter.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		String sql = statementHandler.getBoundSql().getSql();
		Object paramsObject = statementHandler.getParameterHandler().getParameterObject();
		String params = null;
		if (paramsObject != null) {
			params = paramsObject.toString();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("SQL:\r\n" + sql);
			LOG.debug("Params:\r\n" + params);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// Do nothing!
	}

}
