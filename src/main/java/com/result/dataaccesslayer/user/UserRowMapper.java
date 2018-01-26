package com.result.dataaccesslayer.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserResultSetExtractor executor=new UserResultSetExtractor();
		return executor.extractData(rs);
	}

}
