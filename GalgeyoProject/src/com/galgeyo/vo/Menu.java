package com.galgeyo.vo;

import java.io.Serializable;

//메뉴객체
public class Menu implements Serializable {
	//Field
	private String menuNo;
	private String menuName;
	private String category;
	private int price;
	private double discount;
	private boolean orderYN;
	
	//Constructor
	public Menu(){}

	public Menu(String menuNo, String menuName, String category, int price, double discount,	boolean orderYN) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.orderYN = orderYN;
	}

	//Method
	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isOrderYN() {
		return orderYN;
	}

	public void setOrderYN(boolean orderYN) {
		this.orderYN = orderYN;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  menuNo+","+menuName+","+category+","+price+","+discount+","+orderYN;
	}
}