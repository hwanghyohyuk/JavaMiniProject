package com.galgeyo.controller;

// 회원가입 페이지에서 실행될 기능을 메소드로 구현

public class SignUpController {
	
	/* 회원 가입 페이지 */
	
	// 일반 사용자 회원가입 : 페이지 이동
	public void moveToUserRegister() {
	}

	// 사업자(매장관리자) 회원가입 : 페이지 이동
	public void moveToManagerRegister() {
	}
	
	// 뒤로가기 : 페이지 이동
	public void backToLogin(){}

	/* 일반 사용자 및 매장 관리자 회원 가입 페이지 */
	
	// 아이디 중복확인
	public boolean confirmId(String inputId) {
		boolean result = false;

		return result;
	}

	// 가입하기 : 일반사용자
	public boolean submit(String id, String pwd, String name, String tel) {
		boolean result = false;
		boolean isUser = true; //일반 사용자
		return result;
	}

	// 가입하기 : 사업자(매장관리자)
	public boolean submit(String id, String pwd, String storeName, String ownNo, String tel, String addr, byte type) {
		boolean result = false;
		boolean isUser = false; //매장 관리자
		
		return result;
	}

	// 가입하기 완료 후 페이지 이동
	public void moveToLogin(boolean isSuccess) {

	}
	
	// 뒤로가기 : 페이지 이동
	public void backToSignUp(){}
}
