package dataaccesslayer;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import business.PurchaseData;

public class PurchaseDataImpl implements PurchaseDataDAO{

	public List<PurchaseData> getAllPurchase() {
		JdbcTemplate template = DataConn.getTemplate();
		 System.out.println("inside purchase");
		  //List query = template.query("select * from users ",new Object[]{Id},new UserRowMapper());
		 List query = template.query("select * from purchasedata", new Object[]{}, new PurchaseDataRowMapper());
		  return query;
	}

}
