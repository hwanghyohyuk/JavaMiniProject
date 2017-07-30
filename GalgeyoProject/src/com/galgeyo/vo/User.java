package com.galgeyo.vo;

import java.io.Serializable;

//일반 사용자
public class User implements Serializable{
	//Field
	private boolean isUser;//사용자 or 관리자, true면 사용자 false면 관리자
	private String id; //아이디
	private String pwd; //패스워드
	private String name; //이름
	private String tel; //전화번호
	
	//Constructor
	public User(){}

	public User(boolean isUser,String id, String pwd, String name, String tel) {
		super();
		this.isUser = isUser;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
