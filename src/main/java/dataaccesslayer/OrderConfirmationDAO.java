package dataaccesslayer;

import java.util.List;

import business.OrderConfirmation;
import business.Product;

public interface OrderConfirmationDAO {
	public void saveOrder(List<Product> list);
}
