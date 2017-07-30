package com.galgeyo.controller;

import com.galgeyo.vo.Session;

//로그인 화면에서 사용되는 기능들을 메소드로 구현
public class LoginController {

	
	//로그인 : 사용자 권한 확인
	public Object loginCheck(String userId, String userPassword){
		Object result = null;
		// 0 : 아이디 존재X, 1 : 비밀번호 불일치, 객체 : 성공
		
		return result; //반환된 객체는 로그인성공시 세션에 저장됨
	}	
	
	//로그인 성공 시 : 페이지 이동
	public void moveToMain(Session isUser) {
		//일반사용자
		
		//매장관리자
	}
	//회원가입 : 페이지 이동
	public void moveToRegister(){}
	//ID/PW 찾기 : 페이지 이동
	public void moveToFindInfo(){}
}
