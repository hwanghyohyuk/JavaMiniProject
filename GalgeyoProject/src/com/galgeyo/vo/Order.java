package com.galgeyo.vo;

import java.io.Serializable;
import java.util.*;

//주문내역 객체
public class Order implements Serializable {
	//Field
	private String desStore;//목적지
	private String orderNo; //주문번호
	private String name;  //주문자 이름
	private String tel; //주문자 전화번호
	private String reservation; //예약시간
	private String orderMenu; //주문한 메뉴 이름_가격_수량/이름_가격_수량/이름_가격_수량...
	private boolean acceptOrder; //승낙여부
	
	//Constructor
	public Order(){}

	public Order(String desStore,String orderNo, String name, String tel, String reservation, String orderMenu) {
		super();
		this.desStore = desStore;
		this.orderNo = orderNo;
		this.name = name;
		this.tel = tel;
		this.reservation = reservation;
		this.orderMenu = orderMenu;
		this.acceptOrder = true;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
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

	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	public String getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(String orderMenu) {
		this.orderMenu = orderMenu;
	}

	public boolean isAcceptOrder() {
		return acceptOrder;
	}

	public void setAcceptOrder(boolean acceptOrder) {
		this.acceptOrder = acceptOrder;
	}

	public String getDesStore() {
		return desStore;
	}

	public void setDesStore(String desStore) {
		this.desStore = desStore;
	}

	@Override
	public String toString() {
		return  desStore + "," + orderNo + "," + name + "," + tel + "," + reservation
				+ "," + orderMenu + "," + acceptOrder;
	}
	
	
}