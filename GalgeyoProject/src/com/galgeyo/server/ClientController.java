package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ClientController {

	/*
	 * 클라이언트에서 서버로 보내기 위한 가공작업
	 * */
	
	public Object send(boolean header, byte protocol, Object message){
		Packet result = new ClientSender().send(new Packet(header, protocol, new TimeHandler().getTime(), message));
		return result.getMessage();
	}
}
