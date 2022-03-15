package com.example.demo;

public class pizzaBean {
	public enum Size {
		Child,
		Normal,
		Family
	}
	
	private String Name;
	private int Price;
	private Size PizzaSize;
	
	public pizzaBean(String name, Size pizzaSize) {
		Name = name;
		PizzaSize = pizzaSize;
		
		CalculatePrice();
	}

	public int getPrice() {
		return Price;
	}

	private void CalculatePrice() {
		int myPrice = 0;
		
		switch (this.Name) {
			case "vesuvio":
				myPrice = 80;
				break;
			case "calzone":
				myPrice = 85;
				break;
			case "vegetariana":
				myPrice = 60;
				break;
			default:
				myPrice = 100;
				break;
		}
		
		switch (this.PizzaSize) {
			case Child:
				myPrice -= 5;
				break;
			case Normal:
				myPrice = myPrice;
				break;
			case Family:
				myPrice += 50;
				break;
		}
		
		this.Price = myPrice;
	}

	private String sizeText() {
		String sizeText = "";
		
		switch (this.PizzaSize) {
			case Child:
				sizeText = "barnstorlek";
				break;
			case Normal:
				sizeText = "standard";
				break;
			case Family:
				sizeText = "familjepizza";
				break;
		}
		
		return sizeText;
	}
	
	@Override
	public String toString() {
		
		String pattern = "pizzanamn %s, storlek %s !!!";
		String out = String.format(pattern, this.Name, sizeText());
		
		return out;
	}	

	public String toJsonString() {
		String pattern = "{ \"name\": \"%s\", \"size\": \"%s\", \"Price\": %s}";
		
		String out = String.format(pattern, this.Name, sizeText(), Integer.toString(this.Price));
		
		return out;
	}

}