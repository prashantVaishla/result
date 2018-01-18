package com.result.dataaccesslayer.supplier;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.result.businessLayer.SupplierDetails;
import com.result.dataaccesslayer.DataConn;
@Repository("SupplierDAO")
public class SupplierImpl implements SupplierDAO{

	public List<SupplierDetails> getSuppliers() {
		JdbcTemplate template = DataConn.getTemplate();
		String sql="select SUPPLIER_ID,SUPPLIER_NAME from supplierdetails";
		return template.query(sql, new Object[]{}, new SupplierRowMapper());
		 
	}

}
