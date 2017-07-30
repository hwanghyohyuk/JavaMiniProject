package com.galgeyo.controller;

import com.galgeyo.vo.Session;

public class StoreEditController {
	// 변경사항 제출 후 메인으로이동
		public void submitInfo(String name,String ownNo, String tel, String addr, byte type, String pwd, Session manager) {
			boolean result = false;
			// 세션의 비밀번호와 맞는지 확인하고 맞으면
			// 입력받은데이터로 모두 변경
			// 메인화면으로 이동
			moveToManagerMain(manager);
			// 비밀번호가 맞지않다면
			// 알림 표시
		}

		// 뒤로가기
		public void moveToManagerMain(Session manager) {
		}
}
