package com.galgeyo.model;

public class UserMainModel {
  
  //즐겨찾기 데이터 가져오기
  public void getFavorite(){}
    

  //최근주문내역 데이터 가져오기
    public void getRecentlyOrder(){}
  
  //삭제 후 데이터 업데이트(즐겨찾기)
     public void updateFavoriteData(String userId){}
  
  //삭제 후 데이터 업데이트(최근주문내역)
    public void updateRecentlyData(String userId){}
  
  //주문한 메뉴 데이터 가져오기
    public void getOrderData(String orderNo){}
    
}
