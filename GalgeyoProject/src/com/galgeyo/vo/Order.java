package com.galgeyo.vo;

import java.io.Serializable;
import java.util.*;

//주문내역 객체
public class Order implements Serializable {
	//Field
	private int orderNo; //주문번호
	private String name;  //주문자 이름
	private String tel; //주문자 전화번호
	private String reservation; //예약시간
	private HashMap<Menu, Integer> orderMenu; //주문한 메뉴
	
	//Constructor
	public Order(){}

	public Order(int orderNo, String name, String tel, String reservation, HashMap<Menu, Integer> orderMenu) {
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

	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}

	public HashMap<Menu, Integer> getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(HashMap<Menu, Integer> orderMenu) {
		this.orderMenu = orderMenu;
	}
}