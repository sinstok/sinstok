package model;

public class CartItem {
	private Product product;
	private int quantity;
	
	public CartItem(Product product){
		this.product = product;
		quantity = 1;
	}
	
	public double getTotal(){
		return product.getPriceInEuro() * quantity;
	}
	
	public void incQuantity(){
		quantity++;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
