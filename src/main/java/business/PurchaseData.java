package business;
//---------+-----------+-------------+---------------+-----
//ITEM_ID | ITEM_NAME | SUPPLIER_ID | SUPPLIER_NAME | QTY
public class PurchaseData {
	private String itemID;
	private String ItemName;
	private String supplierId;
	private String supplierName;
	private float Qty;
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
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
		return Qty;
	}
	public void setQty(float qty) {
		Qty = qty;
	}
	@Override
	public String toString(){
		return "PurchaseData +"+"["+itemID+"]";
	}
}
