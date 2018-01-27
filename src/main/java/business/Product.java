package business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
/* @Table(name="product") */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productName;
	@Id
	private String productId;
	private int quantity;
	private int maxQuantity;
	private double price;

	public Product() {
	}

	public Product(String productName, String productId, int quantity, int maxQuantity, double price) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.quantity = quantity;
		this.maxQuantity = maxQuantity;
		this.price = price;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
