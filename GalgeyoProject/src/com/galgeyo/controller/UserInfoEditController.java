package com.galgeyo.controller;

import com.galgeyo.vo.Session;

public class UserInfoEditController {
	public void submitInfo(String name, String tel, String pwd, Session user) {
		boolean result = false;
		// 세션의 비밀번호와 맞는지 확인하고 맞으면
		// 입력받은데이터로 모두 변경
		// 메인화면으로 이동
		// 비밀번호가 맞지않다면
		// 알림 표시
	}

	// 뒤로가기
	public void moveToUserMain(Session user) {
	}

}
