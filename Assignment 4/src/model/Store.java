package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class Store {
	private List<Item> cart;
	private Locale locale;
	private ResourceBundle apptexts;
	private NumberFormat formatter;
	
	public Store(Locale l){
		locale = l;
		formatter = NumberFormat.getCurrencyInstance(locale);
		apptexts = ResourceBundle.getBundle("apptexts", locale);
		cart = new ArrayList<Item>();
	}
	
	public void getItems(){
		if(cart.isEmpty()){
			System.out.println(apptexts.getString("isEmpty"));
		} else {
			for(Item e : cart){
				System.out.print(apptexts.getString("name") + ": " + apptexts.getString(e.getName()) + ", ");
				System.out.println(apptexts.getString("price") + ": " + formatter.format(e.getPris()));
			}
		}
		System.out.println();
	}
	
	public void addItem(Item e){
		cart.add(e);
	}
}
