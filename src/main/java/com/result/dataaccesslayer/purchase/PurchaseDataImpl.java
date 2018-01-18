package com.result.dataaccesslayer.purchase;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.result.businessLayer.PurchaseData;
import com.result.dataaccesslayer.DataConn;
@Repository("purchaseDAO")
public class PurchaseDataImpl implements PurchaseDAO{
	public List<PurchaseData> getAllPurchase() {
		JdbcTemplate template = DataConn.getTemplate();
		 System.out.println("inside purchase");
		  return template.query("select * from purchasedata", new Object[]{}, new PurchaseDataRowMapper());
	}

	public void savePurchaseData(PurchaseData purchaseData) {
		JdbcTemplate template = DataConn.getTemplate();
		System.out.println("purchase data insert query");
		String sqlQuery="Insert into purchasedata(ITEM_ID,ITEM_NAME,SUPPLIER_ID,SUPPLIER_NAME,QTY,PURCHASE_DATE)"+"Values(?,?,?,?,?,?)";
		int update = template.update(sqlQuery, purchaseData.getItemID(),purchaseData.getItemName(),
				purchaseData.getSupplierId(),purchaseData.getSupplierName(),purchaseData.getQty());
	}

	public int deletePurchaseData(String id) {
		JdbcTemplate template = DataConn.getTemplate();
		System.out.println("delete purchase data using id");
		String sqlDelQuery="Delete from purchasedata where ITEM_ID=?";
		 int update = template.update(sqlDelQuery, id);
		 return update;
		
	}
	

}
