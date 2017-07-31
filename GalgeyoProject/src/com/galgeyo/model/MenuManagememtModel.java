package com.galgeyo.model;

public class MenuManagememtModel {

  //매장의 메뉴 데이터 받아오기
  public HashMap getMenu(String tel){}
  
  //검색한 키워드로 메뉴 데이터 받아오기
  public HashMap selectMenu(String keyword){}
  
  //체크한 메뉴 삭제 후 업데이트
  public HashMap updateMenuDelete(String[] menuNo){}
  
  //입력한 정보로 메뉴를 추가하고 업데이트
  public HashMap updateMenuInsert(String MenuNo, String MenuName, String category,
                                  int price, double discount, String imgURL, boolean orderYN){}

}
