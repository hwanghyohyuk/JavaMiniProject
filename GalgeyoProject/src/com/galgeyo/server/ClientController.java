package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ClientController {

	public Object send(boolean header, byte protocol, Object message){
		Packet result = new ClientSender().send(new Packet(header, protocol, new TimeHandler().getTime(), message));
		System.out.println(result.toString());
		return result.getMessage();
	}
}
