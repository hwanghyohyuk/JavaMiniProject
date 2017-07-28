package com.galgeyo.vo;

//관리자 객체
public class Manager extends User{
	//Field
	private String ownNo;
	private String addr;
	private String type;
	
	//Constructor
	public Manager(){}

	public Manager(String id, String pwd, String name, String tel, char code,
			String ownNo, String addr, String type) {
		super(id, pwd, name, tel, code);
		this.ownNo = ownNo;
		this.addr = addr;
		this.type = type;
	}

	public String getOwnNo() {
		return ownNo;
	}

	public void setOwnNo(String ownNo) {
		this.ownNo = ownNo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}