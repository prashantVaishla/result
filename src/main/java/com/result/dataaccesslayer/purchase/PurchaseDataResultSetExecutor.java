package com.result.dataaccesslayer.purchase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.result.businessLayer.PurchaseData;
//ITEM_ID | ITEM_NAME | SUPPLIER_ID | SUPPLIER_NAME | QTY
public class PurchaseDataResultSetExecutor implements ResultSetExtractor{
	/*@Autowired
	PurchaseData purchaseObj;*/
	
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		PurchaseData purchaseObj=new PurchaseData();
		purchaseObj.setItemID(rs.getString("ITEM_ID"));
		purchaseObj.setItemName(rs.getString("ITEM_NAME"));
		purchaseObj.setSupplierName(rs.getString("SUPPLIER_NAME"));
		purchaseObj.setSupplierId(rs.getString("SUPPLIER_ID"));
		purchaseObj.setQty(rs.getFloat("QTY"));
		purchaseObj.setDate(rs.getDate("PURCHASE_DATE"));
		
		return purchaseObj;
	}

}
