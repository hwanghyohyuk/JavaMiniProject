package com.galgeyo.model;

import java.util.HashMap;

import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Menu;
import com.galgeyo.vo.Order;

public class OrderMenuModel implements Protocol{
 
  //매장 리스트 데이터 받아오기
  public HashMap<String, Manager> getStore(){
	return null;}
  
  //해당 매장의 메뉴 데이터 받아오기
  public HashMap<String, Menu> getMenu(Manager store){
	return null;}
    
  //주문 내역 저장
  public void sendOrder(Order o){}

}
