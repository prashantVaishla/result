package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import business.ConfirmationTO;
import business.OrderConfirmation;
import dataaccesslayer.OrderConfirmationDAO;

@Service("orderConfirmationService")
/*@Transactional*/
public class OrderConfirmationServiceImpl implements OrderConfirmationService {

	@Autowired
	OrderConfirmationDAO confirmationDAO;

	public void saveOrder(OrderConfirmation orderConfirmation) {
		confirmationDAO.saveOrder(orderConfirmation.getPersonListContainer().getProductList());
		System.out.println("Finished sAving");
	}

}
