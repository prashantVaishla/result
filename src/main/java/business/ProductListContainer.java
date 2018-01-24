package business;

import java.util.LinkedList;
import java.util.List;

public class ProductListContainer {

	// Important. Set this to a default List in order to avoid null pointer
	// exceptions when the list is empty
	private List<Product> productList = new LinkedList<Product>();

	public ProductListContainer() {
	}

	public ProductListContainer(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
