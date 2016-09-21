package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> cartItems;
	
	public Cart(){
		cartItems = new ArrayList<CartItem>();
	}
	
	public double getTotal(){
		double total = 0;
		for(CartItem item : cartItems){
			total += item.getTotal();
		}
		return total;
	}
	
	public void addProduct(Product product){
		boolean inList = false;
		
		//update cartitem if it exists 
		for(CartItem item : cartItems){
			if(item.getProduct() == product){
				item.incQuantity();
				inList = true;
			}
		}
		
		//add new cartitem if product does not exist
		if(!inList){
			CartItem item = new CartItem(product);
			cartItems.add(item);
		}
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	
}
