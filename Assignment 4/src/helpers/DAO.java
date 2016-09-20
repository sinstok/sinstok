package helpers;

import java.util.ArrayList;
import java.util.List;

import model.Description;
import model.Product;

public class DAO {
	List<Product> products;
	
	public DAO(){
		Product prod1 = new Product("Shattered Coffee Cup (TM)", 44, "images/ShatteredCoffeeCup.jpg");
		Product prod2 = new Product("Fixed Coffee Cup (TM)", 4000, "images/FixedCoffeeCup.jpg");
		
		Description desc1no = new Description("no", "Denne kaffekoppen ble knust under leveranse.");
		Description desc1en = new Description("en", "This coffee cup shattered during delivery.");
		Description desc1de = new Description("de", "Diese Kaffeetasse zerbrochen während der Geburt.");
		
		Description desc2no = new Description("no", "Denne kaffekoppen var knust, men nå er den fikset");
		Description desc2en = new Description("en", "This coffee cup was shattered, but now it is fixed.");
		Description desc2de = new Description("de", "Diese Kaffeetasse war erschüttert, aber jetzt ist es fixiert.");
		
		prod1.addDescription(desc1no);
		prod1.addDescription(desc1en);
		prod1.addDescription(desc1de);
		
		prod2.addDescription(desc2no);
		prod2.addDescription(desc2en);
		prod2.addDescription(desc2de);
		
		products = new ArrayList<Product>();
		
		products.add(prod1);
		products.add(prod2);
	}
	
	public List<Product> getProducts(){
		return products;
	}
}
