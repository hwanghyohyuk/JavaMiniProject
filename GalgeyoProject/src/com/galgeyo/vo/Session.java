package com.galgeyo.vo;

import java.io.Serializable;

public class Session implements Serializable{
	private Object session;

	public Session() {
		super();
	}

	public Session(Object session) {
		super();
		this.session = session;
	}

	public Object getSession() {
		return session;
	}

	public void setSession(Object session) {
		this.session = session;
	}	
}
