package com.galgeyo.model;

public class ManagerMainModel {

  //응답 대기자 리스트
	public HashMap waitUsers(String tel){}
	
	//(승낙한)예약 주문자 리스트
	public HashMap reserUsers(String orderNo){}
	
	//응답대기자 리스트에서 체크(승낙)한 유저를 예약주문자 리스트에 추가 후 업데이트
	public HashMap updateAcceptUsers(String[] orderNo){}
	
	//삭제 후 데이터 업데이트(예약 주문자 리스트)
	public HashMap updateReserUsers(String[] orderNo){}
  
}
