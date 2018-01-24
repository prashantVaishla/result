package business;

public class OrderConfirmation {
	ProductListContainer personListContainer;
	double total;
	public OrderConfirmation(ProductListContainer personListContainer, double total) {
		super();
		this.personListContainer = personListContainer;
		this.total = total;
	}
	public OrderConfirmation() {
	}
	public ProductListContainer getPersonListContainer() {
		return personListContainer;
	}
	public void setPersonListContainer(ProductListContainer personListContainer) {
		this.personListContainer = personListContainer;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
