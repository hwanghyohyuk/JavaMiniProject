package com.galgeyo.vo;

import java.io.Serializable;

//매장관리자
public class Manager extends User implements Serializable{
	//Field
	private String ownNo;
	private String addr;
	private byte type;
	private boolean isOpen;
	
	//Constructor
	public Manager(){}

	public Manager(boolean isUser, String id, String pwd, String name, String tel, String ownNo, String addr, byte type) {
		super(isUser, id, pwd, name, tel);
		this.ownNo = ownNo;
		this.addr = addr;
		this.type = type;
		this.isOpen = false;
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

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
}