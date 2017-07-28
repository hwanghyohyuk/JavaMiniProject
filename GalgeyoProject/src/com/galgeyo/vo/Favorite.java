package com.galgeyo.vo;

//즐겨찾기 객체
public class Favorite {
	//Field
	private String userID; //회원아이디
	private String storeName; //가게이름
	private String tel; //가게전화번호
	
	
	//Constructor
	public Favorite(String userID, String storeName, String tel) {
		super();
		this.userID = userID;
		this.storeName = storeName;
		this.tel = tel;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
}