package dataaccesslayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import business.Product;

@Repository("inventoryDAO")
public class InventoryDAOImpl implements InventoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> getProductNames(String query) {
		String queryString = "SELECT " + "ITEM_NAME" + " FROM PURCHASEDATA WHERE ITEM_NAME LIKE '%" + query + "%' GROUP BY "
				+ "ITEM_NAME";	
		List<String> data = jdbcTemplate.query(queryString, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		return data;
	}

	public List<Product> getProductDetails(String query) {
		String queryString = "SELECT " + "ITEM_NAME, ITEM_ID, PRICE, QTY" + " FROM PURCHASEDATA WHERE ITEM_NAME LIKE '%" + query + "%'";	
		List<Product> data = jdbcTemplate.query(queryString, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setProductName(rs.getString("ITEM_NAME"));
				p.setProductId(rs.getString("ITEM_ID"));
				p.setPrice(Double.parseDouble(rs.getString("PRICE")));
				p.setMaxQuantity(rs.getInt("QTY"));
				return p;
			}
		});
		return data;
	}

}
