package com.result.dataaccesslayer.purchase;
import java.util.List;

import com.result.businessLayer.*;
public interface PurchaseDAO {

	public List<PurchaseData> getAllPurchase();
	public void savePurchaseData(PurchaseData purchaseData);
	public int deletePurchaseData(String Id);
}
