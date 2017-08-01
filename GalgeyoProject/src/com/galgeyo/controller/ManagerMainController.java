package com.galgeyo.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.zip.InflaterInputStream;

import javax.swing.table.DefaultTableModel;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.Session;

//매장 관리자의 메인 화면에 대한 메소드 구현

public class ManagerMainController {

	// 예약 가능 / 불가능 (switch button)
	public boolean switchReservation(Session manager) {
		if (((Manager) manager.getSession()).isOpen()) {
			((Manager) manager.getSession()).setOpen(false);
			//세션을 서버로 보냄
			return false;
		} else {
			((Manager) manager.getSession()).setOpen(true);
			//세션을 서버로 보냄
			return true;
		}
	}

	//응답 대기자 리스트
	public void waitUserList(HashMap<String, Order> waitUsers, DefaultTableModel dtm){
		
	}
	//예약 주문자 리스트
	public void reserUserList(HashMap<String, Order> reserUsers, DefaultTableModel dtm){}
	//응답 대기자 리스트 → 예약 주문자 리스트
	public void updateAcceptUserList(int row, DefaultTableModel src_dtm,DefaultTableModel des_dtm){}
	//예약 주문자 리스트 아이템삭제
	public void updateReserUserList(int row, DefaultTableModel dtm){}
	// 로그아웃 후 메인으로 이동
	public void logout(Session manager) {
	}
}
