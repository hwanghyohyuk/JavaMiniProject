package com.galgeyo.controller;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import com.galgeyo.vo.Order;
import com.galgeyo.vo.Session;

public class TotalOrderController {

	// 주문 내역 통계 계산
	// calculateNo = {0 : today, 1 : month, 2 : ave}
	public void totalOrderCalculate(HashMap<String, Order> order, byte calculateNo){
		
	}
	// 주문 내역 통계 리스트
	public void totalOrderList(HashMap<String, Order> order, DefaultTableModel dtm) {
	}
	
	// 뒤로가기
	public void moveToManagerMain(Session manager){}
}
