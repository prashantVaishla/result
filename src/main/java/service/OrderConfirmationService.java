package service;

import business.ConfirmationTO;
import business.OrderConfirmation;

public interface OrderConfirmationService {
	public void saveOrder(OrderConfirmation confirmationTO);
}
