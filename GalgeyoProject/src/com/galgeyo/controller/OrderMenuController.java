package com.galgeyo.controller;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

import javax.swing.table.DefaultTableModel;
import com.galgeyo.vo.*;


public class OrderMenuController {
	HashMap serch = new HashMap(); 
	//매장 리스트
	public void storeList(HashMap<String, Manager> store, DefaultTableModel dtm){
		Set<Entry<String, Manager>> set  = store.entrySet();
		Iterator iter = set.iterator();
		int i=0;
		while(iter.hasNext()) {
			Entry<String, Manager> entry  = (Entry<String, Manager>)iter.next();
			String key = entry.getKey();
			Manager value = entry.getValue();
			Object[][] obj = new Object[store.size()][3];
			
			obj[i][0] = value.getName();
			obj[i][1] = value.getTel();
			obj[i][2] = value.getType();
			dtm.addRow(obj);
			i++;
		}
		
	}
	
	//매장검색
	public DefaultTableModel searchStore(String storeName, DefaultTableModel dtm){
		DefaultTableModel resultDtm = null;
		
		Set users = serch.entrySet();
		Iterator iter = users.iterator();
		
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			resultDtm = (DefaultTableModel)entry.getKey();
			Menu m  = (Menu)entry.getValue();
			
			if(m.getMenuName().equals(storeName)== true) break;	
		}
		return resultDtm;		
	}
	
	//메뉴판
	public void menuList(Manager store, DefaultTableModel dtm){}
	
	//주문하기
	public Order submitOrder(Session user, DefaultTableModel dtm){
		return null;}
	
	//뒤로가기
	public void moveToSelectMenu(Session user){}
	
	public static void main(String[] args) {
		new OrderMenuController();
	}
}
