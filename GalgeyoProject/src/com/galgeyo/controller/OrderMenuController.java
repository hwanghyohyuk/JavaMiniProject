package com.galgeyo.controller;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.Session;

public class OrderMenuController {

	//매장 리스트
	public void storeList(HashMap<String, Manager> store, DefaultTableModel dtm){}
	
	//매장검색
	public DefaultTableModel searchStore(String storeName, DefaultTableModel dtm){
		DefaultTableModel resultDtm = null;
		
		return resultDtm;		
	}
	
	//메뉴판
	public void menuList(Manager store, DefaultTableModel dtm){}
	
	//주문하기
	public Order submitOrder(Session user, DefaultTableModel dtm){
		return null;}
	
	//뒤로가기
	public void moveToSelectMenu(Session user){}
}
