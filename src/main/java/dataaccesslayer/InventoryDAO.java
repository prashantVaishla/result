package dataaccesslayer;

import java.util.List;

import business.Product;

public interface InventoryDAO {
	List<String> getProductNames(String query);

	List<Product> getProductDetails(String query);
}
