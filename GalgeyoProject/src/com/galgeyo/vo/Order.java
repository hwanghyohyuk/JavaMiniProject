package com.galgeyo.vo;

import java.util.*;

//주문내역 객체
public class Order {
	//Field
	private int orderNo; //주문번호
	private String name;  //주문자 이름
	private String tel; //주문자 전화번호
	private Date reservation; //예약시간
	private HashMap orderMenu; //주문한 메뉴
	
	//Constructor
	public Order(){}

	public Order(int orderNo, String name, String tel, Date reservation, HashMap orderMenu) {
		super();
		this.orderNo = orderNo;
		this.name = name;
		this.tel = tel;
		this.reservation = reservation;
		this.orderMenu = orderMenu;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getReservation() {
		return reservation;
	}

	public void setReservation(Date reservation) {
		this.reservation = reservation;
	}

	public HashMap getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(HashMap orderMenu) {
		this.orderMenu = orderMenu;
	}
}