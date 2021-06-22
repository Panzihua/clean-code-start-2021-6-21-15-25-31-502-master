package com.tw.academy.basic.$3_feature_envy.practiceTwo;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double calculateLineItemPrice() {
		return getPrice() * getQuantity();
	}

}