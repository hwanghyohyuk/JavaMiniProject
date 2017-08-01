package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ServerController implements Protocol {
	private ServerModel sm = new ServerModel();
	/*
	 * ServerThread에서 받은 데이터를 분석하여 모델에 전달이 필요하면 전달 반환값은 Packet
	 */
	
	//sendPacket = new Packet(receivePacket.isHeader(), LOGIN_SUCCESS, new TimeHandler().getTime(), null);

	public Packet POSTprocess(Packet receivePacket) {
		System.out.println("서버 컨트롤러 실행");
		byte protocol = receivePacket.getProtocol();
		Object message = receivePacket.getMessage();
		Packet tempPacket = null;
		switch (protocol) {
		case LOGIN:
			System.out.println("로그인  처리");
			Object sendMessage = sm.loginCheck(message);
			 tempPacket = new Packet(POST, LOGIN, new TimeHandler().getTime(), sendMessage);
			break;
		}
		System.out.println("서버 컨트롤러 종료");
		Packet sendPacket = tempPacket;
		return sendPacket;
	}

	public Packet GETprocess(Packet receivePacket) {
		byte protocol = receivePacket.getProtocol();
		Object message = receivePacket.getMessage();
		
		switch (protocol) {

		}
		
		Packet sendPacket = null;
		return sendPacket;
	}
}
