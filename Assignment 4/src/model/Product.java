package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private static int pnoCounter = 0;
	private int pno;
	private String pName;
	private List<Description> descriptions;
	private double priceInEuro;
	private String imageFile;
	
	public Product(String pName, double priceInEuro, String imageFile){
		pno = pnoCounter++;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
		
		descriptions = new ArrayList<Description>();
	}
	
	public void addDescription(Description description){
		descriptions.add(description);
	}
	
	public Description getDescription(String locale){
		for(Description desc : descriptions){
			if(desc.getLangCode().equals(locale)){
				return desc;
			}
		}
		
		return null;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPriceInEuro() {
		return priceInEuro;
	}

	public void setPriceInEuro(double priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}
	
	
	
}
