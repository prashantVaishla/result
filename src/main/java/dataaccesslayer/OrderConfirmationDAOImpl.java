package dataaccesslayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import business.Product;

@Repository("orderConfirmationDAO")
public class OrderConfirmationDAOImpl implements OrderConfirmationDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	@Transactional
	public void saveOrder(List<Product> list) {
		for(Product p: list){
			entityManager.persist(p);
		}
	}

}
