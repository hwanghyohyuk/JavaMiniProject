package com.galgeyo.vo;

import java.io.Serializable;

//메뉴객체
public class Menu implements Serializable {
	//Field
	private int menuNo;
	private String menuName;
	private String category;
	private int price;
	private double discount;
	private String imgURL;
	private boolean orderYN;
	
	//Constructor
	public Menu(){}

	public Menu(int menuNo, String menuName, String category, int price, double discount, String imgURL,	boolean orderYN) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.imgURL = imgURL;
		this.orderYN = orderYN;
	}

	//Method
	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
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

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public boolean isOrderYN() {
		return orderYN;
	}

	public void setOrderYN(boolean orderYN) {
		this.orderYN = orderYN;
	}
}