package com.galgeyo.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderList implements Serializable{
//사용자 주문리스트 객체, 매장관리자 최종주문리스트, 매장관리자 대기자리스트
	ArrayList<Order> orderList = new ArrayList<Order>();

	public OrderList(ArrayList<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}	
}
