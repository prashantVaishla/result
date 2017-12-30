package dataaccesslayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import business.PurchaseData;
//ITEM_ID | ITEM_NAME | SUPPLIER_ID | SUPPLIER_NAME | QTY
public class PurchaseDataResultSetExecutor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		PurchaseData purchaseObj=new PurchaseData();
		purchaseObj.setItemID(rs.getString("ITEM_ID"));
		purchaseObj.setItemName(rs.getString("ITEM_NAME"));
		purchaseObj.setSupplierName(rs.getString("SUPPLIER_NAME"));
		purchaseObj.setSupplierId(rs.getString("SUPPLIER_ID"));
		purchaseObj.setQty(rs.getFloat("QTY"));
		
		return purchaseObj;
	}

}
