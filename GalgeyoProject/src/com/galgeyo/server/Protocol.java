package com.galgeyo.server;

public interface Protocol {
	
	public static final boolean POST = true;
	public static final boolean GET = false;
	
	public static final byte LOGIN = 3;  //로그인 ::: ID,PW입력 후 [로그인] 눌렀을 때
	public static final byte REG_USER = 4;  //회원가입 ::: 정보 입력 후 [SUBMIT] 눌렀을 때
	public static final byte REG_ID_CHECK = 5;  //회원가입 ::: ID 입력 후 [중복확인] 눌렀을 때
	public static final byte REG_MOD_USER = 6;  // ★모르겠음
	public static final byte FIND_ID = 7;  //ID/PW찾기 ::: 이름, 전화번호 입력 후 ID[검색] 눌렀을 때
	public static final byte FIND_PW = 8;  //ID/PW찾기 ::: 아이디, 전화번호 입력 후 PW[검색] 눌렀을 때
	public static final byte CHANGE_RESER_STATUS = 9;  //매장관리자 메인 ::: 예약상태변경을 위해 [버튼] 눌렀을 때
	public static final byte ACCEPT_ORDER = 10;  //매장관리자 메인 ::: 응답대기자 리스트에서 주문자 체크 후 [주문승낙] 눌렀을 때
	public static final byte ACCEPT_CANCEL = 11;  //매장관리자 메인 ::: 예약주문자 리스트에서 주문자 체크 후 [승낙취소] 눌렀을 때
	public static final byte CHECK_PWD_USER = 12;  //매장/개인정보수정 ::: 사용자(혹은 매장) 정보 입력 후 [SUBMIT] 눌렀을 때 본인이 맞는지 패스워드를 입력받아 확인
	public static final byte EDIT_USER_INFO = 13;  //매장/개인정보수정 ::: 사용자(혹은 매장) 정보 입력 후 [SUBMIT] 눌렀을 때
	public static final byte ADD_MENU = 14;  //메뉴관리 ::: 메뉴 정보 입력 후 [SUBMIT] 눌렀을 때
	public static final byte DEL_MENU = 15;  //메뉴관리 ::: 삭제할 메뉴 체크 후 [DELETE] 눌렀을 때
	public static final byte DEL_THIS_FAVORITE = 16;  //회원(소비자) 메인 ::: 즐겨찾기리스트에서 [삭제] 눌렀을 때
	public static final byte DEL_THIS_RECENTLY_ORDER = 17;  //회원(소비자) 메인 ::: 최근 주문 내역에서 [취소] 눌렀을 때
	public static final byte ORDER_MENU = 18;  //메뉴 주문 ::: 주문할 메뉴와 수량 입력 후 [주문하기] 눌렀을 때
	
	public static final byte ANSWER_WAIT_LIST = 30; 	//응답대기자 리스트
	public static final byte PRE_ODER_LIST = 31; 	//예약주문자 리스트
	public static final byte MENU_MANAGEMENT_LIST = 32;	//메뉴관리 (메뉴리스트)
	public static final byte ORDER_HISTORY_STATISTICS = 33;	//주문내역통계
	public static final byte FAVORITES_LIST = 34;	//즐겨찾기 리스트
	public static final byte ORDER_HISTORY_LIST = 35;	//최근주문내역리스트
	public static final byte STORE_LIST = 36;	//매장리스트
	public static final byte STORE_MENU_LIST = 37;	//매장의 메뉴리스트
	
	
}
