package com.result.dataaccesslayer.supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SupplierRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		SupplierResultSetExecutor executor=new SupplierResultSetExecutor();
		return executor.extractData(rs);
	}

}
