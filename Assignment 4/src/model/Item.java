package model;

public class Item {
	private String name;
	private double pris;
	
	Item(String n, double p){
		this.name = n;
		this.pris = p;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getName() {
		return name;
	}
	
	
}
