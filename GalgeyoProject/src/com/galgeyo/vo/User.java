package com.galgeyo.vo;

//회원객체
public class User {
	//Field
	private String id; //회원 아이디
	private String pwd; //회원 패스워드
	private String name; //회원 이름
	private String tel; //회원 전화번호
	private char code; //회원 구분코드
	
	//Constructor
	public User(){}

	public User(String id, String pwd, String name, String tel, char code) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.code = code;
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

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}
}
