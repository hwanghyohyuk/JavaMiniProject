package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ServerGETController {
	
	private ServerPOSTModel sm = new ServerPOSTModel();
	/*
	 * ServerThread에서 받은 데이터를 분석하여 모델에 전달이 필요하면 전달 반환값은 Packet
	 */

	// sendPacket = new Packet(receivePacket.isHeader(), LOGIN_SUCCESS, new
	// TimeHandler().getTime(), null);
	
	public Packet GETprocess(Packet receivePacket) {
		byte protocol = receivePacket.getProtocol();
		Object message = receivePacket.getMessage();

		switch (protocol) {

		}

		Packet sendPacket = null;
		return sendPacket;
	}
}
