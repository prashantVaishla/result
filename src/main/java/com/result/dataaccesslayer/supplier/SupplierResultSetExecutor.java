package com.result.dataaccesslayer.supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.result.businessLayer.SupplierDetails;;
// SUPPLIER_NAME | PHONE_NUMBER |
public class SupplierResultSetExecutor implements ResultSetExtractor{

	public SupplierDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
		SupplierDetails supplerObj=new SupplierDetails();
		supplerObj.setSupplierId(rs.getInt("SUPPLIER_ID"));
		supplerObj.setSupplierName(rs.getString("SUPPLIER_NAME"));
		//supplerObj.setPhoneNumber(rs.getLong("SUPPLIER_NAME"));
		return supplerObj;
	}

}
