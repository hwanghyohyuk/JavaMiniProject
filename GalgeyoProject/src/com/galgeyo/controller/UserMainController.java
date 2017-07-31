package com.galgeyo.controller;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import com.galgeyo.vo.*;

//일반 사용자의 메인 화면에 대한 메소드 구현

public class UserMainController {
	
	//일반 사용자의 즐겨찾기 정보 로드
	public void favoriteList(HashMap<String, Manager> favorite, DefaultTableModel dtm){}
	//HashMap<사업자번호, 매장관리자 객체>
	
	//일반 사용자의 즐겨찾기 정보 삭제
	
	//일반 사용자의 최근 주문내역 로드
	public void recentlyOrder(HashMap<String, Order> recentlyOrder, DefaultTableModel dtm){}
	//HashMap<주문번호, 주문 객체>
	
	//일반 사용자의 최근 주문내역 상세보기
	
	//일반 사용자의 최근 주문내역 삭제
	
	//메뉴 선택 화면으로 이동
	public void moveToSelectMenu(Session user){}
	
	//개인정보 수정 화면으로 이동
	public void moveToUserInfoEdit(Session user){}
	
	//로그아웃 후 메인으로 이동
	public void logout(Session user){
	}
}
