package com.galgeyo.vo;

import java.io.Serializable;

public class Packet implements Serializable {

	// 사용자 정의 패킷
	// 패킷은 boolean,byte,Date,String 순서로 객체화된다
	// 패킷에 필요한 정보를 담고 객체스트림으로 입출력한다.

	private boolean header; // POST = true , GET = false
	private byte protocol;
	private String time;
	private Object massage;

	public Packet() {
		super();
	}

	public Packet(boolean header, byte protocol, String time, Object massage) {
		super();
		this.header = header;
		this.protocol = protocol;
		this.time = time;
		this.massage = massage;
	}

	public boolean isHeader() {
		return header;
	}

	public void setHeader(boolean header) {
		this.header = header;
	}

	public byte getProtocol() {
		return protocol;
	}

	public void setProtocol(byte protocol) {
		this.protocol = protocol;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Object getMassage() {
		return massage;
	}

	public void setMassage(Object massage) {
		this.massage = massage;
	}

	@Override
	public String toString() {
		if (this.massage instanceof String) {
			return this.header + "," + this.protocol + "," + this.time + "," + (String) this.massage;
		} else {
			return this.header + "," + this.protocol + "," + this.time + "," + this.massage;
		}
	}
}