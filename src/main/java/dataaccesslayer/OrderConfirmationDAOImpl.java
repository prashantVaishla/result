package dataaccesslayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import business.Product;

@Repository("orderConfirmationDAO")
public class OrderConfirmationDAOImpl implements OrderConfirmationDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*@PersistenceContext
	EntityManager entityManager;
	@Transactional*/
	public void saveOrder(List<Product> list) {
		for (Product p : list) {
			String updateQuery = "update PURCHASEDATA set QTY = ? where ITEM_ID = ?";
			jdbcTemplate.update(updateQuery, p.getMaxQuantity() - p.getQuantity(), p.getProductId());
			// entityManager.persist(p);
		}
	}

}
