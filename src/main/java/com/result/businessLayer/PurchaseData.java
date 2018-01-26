package com.result.businessLayer;

import java.sql.Date;

//---------+-----------+-------------+---------------+-----
//ITEM_ID | ITEM_NAME | SUPPLIER_ID | SUPPLIER_NAME | QTY
public class PurchaseData {
	private String itemID;
	private String itemName;
	private String supplierId;
	private String supplierName;
	private float qty;
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	@Override
	public String toString(){
		return "PurchaseData "+"["+itemID+"]"+"["+itemName+"]"+"["+supplierId+"]"+"["+supplierName+"]"+"["+qty+"]"+"["+date+"]";
	}
}
