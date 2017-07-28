package com.galgeyo.vo;

//가게 객채
public class Store extends Manager{
	//Field
	private String name; //가게이름
	private String tel; //가게전화번호
	private String addr; //가게 주소
	
	
	//Constructor
	public Store(){}


	public Store(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}


	//Method
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


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}
}