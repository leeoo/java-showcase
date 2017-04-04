package com.lex.showcase.common.mybatis.type_hander;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.lex.showcase.common.mybatis.type.ActiveOrInactive;

public class ActiveOrInactiveEnumHandler implements TypeHandler<ActiveOrInactive> {

	@Override
	public void setParameter(PreparedStatement ps, int i, ActiveOrInactive parameter, JdbcType jdbcType)
			throws SQLException {
		if (parameter == null) {
			ps.setString(i, null);
			return;
		}
		String flag = parameter.value();
		ps.setString(i, flag);
	}

	@Override
	public ActiveOrInactive getResult(ResultSet rs, String columnName) throws SQLException {
		String flag = rs.getString(columnName);
		if (StringUtils.isBlank(flag)) {
			return null;
		}
		return ActiveOrInactive.fromValue(flag);
	}

	@Override
	public ActiveOrInactive getResult(ResultSet rs, int columnIndex) throws SQLException {
		String flag = rs.getString(columnIndex);
		if (StringUtils.isBlank(flag)) {
			return null;
		}
		return ActiveOrInactive.fromValue(flag);
	}

	@Override
	public ActiveOrInactive getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String flag = cs.getString(columnIndex);
		if (StringUtils.isBlank(flag)) {
			return null;
		}
		return ActiveOrInactive.fromValue(flag);
	}

}
