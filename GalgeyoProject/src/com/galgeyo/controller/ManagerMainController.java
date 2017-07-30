package com.galgeyo.controller;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;

//매장 관리자의 메인 화면에 대한 메소드 구현

public class ManagerMainController {

	// 예약 가능 / 불가능 (switch button)
	public boolean switchReservation(Session manager) {
		if (((Manager) manager.getSession()).isOpen()) {
			((Manager) manager.getSession()).setOpen(false);
			return false;
		} else {
			((Manager) manager.getSession()).setOpen(true);
			return true;
		}
	}

	// 매장정보 수정 화면으로 이동
	public void moveToStoreEdit(Session manager) {
	}

	// 메뉴 관리 화면으로 이동
	public void moveToMenuManagement(Session manager) {
	}

	// 주문 내역 통계 화면으로 이동
	public void moveToTotalOrder(Session manager) {
	}

	// 로그아웃 후 메인으로 이동
	public void logout(Session manager) {
	}
}
