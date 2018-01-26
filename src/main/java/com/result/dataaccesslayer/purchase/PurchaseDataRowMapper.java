package com.result.dataaccesslayer.purchase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PurchaseDataRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PurchaseDataResultSetExecutor executor=new PurchaseDataResultSetExecutor();
		 return executor.extractData(rs);
	}

}
