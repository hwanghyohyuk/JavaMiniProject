package com.galgeyo.model;

import java.util.HashMap;

import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.Session;

public class ManagerMainModel implements Protocol{

	//예약 가능 / 불가능
	public void switchReservation(Session manager){
		//매장관리자 상태정보 변경		
	}
	
  //응답 대기자 리스트
	public HashMap<String, Order> waitUsers(){
		HashMap<String, Order> temp=null;
		return temp;
	}
	
	//(승낙한)예약 주문자 리스트
	public HashMap<String, Order> reserUsers(){
		HashMap<String, Order> temp=null;
		return temp;
	}
	
	//응답대기자 리스트에서 체크(승낙)한 유저를 예약주문자 리스트에 추가 후 업데이트
	public  void updateAcceptUsers(int orderNo){
	//서버로 변경사항 전달	
	}
	
	//삭제 후 데이터 업데이트(예약 주문자 리스트)
	public void updateReserUsers(int orderNo){
	//서버로 변경사항전달
	}
  
}
