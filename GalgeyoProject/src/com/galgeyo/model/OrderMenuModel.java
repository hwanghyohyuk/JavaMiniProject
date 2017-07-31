package com.galgeyo.model;

public class OrderMenuModel {
 
  //매장 리스트 데이터 받아오기
  public HashMap getStore(String category){}
  
  //해당 매장의 메뉴 데이터 받아오기
  public HashMap getMenu(String tel){}
  
  //검색한 키워드로 매장 데이터 받아오기
  public HashMap selectStore(String keyword){}
  
  //주문 내역 저장
  public void sendOrder(Order o){}

}
