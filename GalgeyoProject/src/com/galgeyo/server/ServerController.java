package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ServerController implements Protocol {
	private ServerModel sm = new ServerModel();
	/*
	 * ServerThread에서 받은 데이터를 분석하여 모델에 전달이 필요하면 전달 반환값은 Packet
	 */
	
	//sendPacket = new Packet(receivePacket.isHeader(), LOGIN_SUCCESS, new TimeHandler().getTime(), null);

	public Packet POSTprocess(Packet receivePacket) {
		System.out.println("서버 컨트롤러 POST process 실행");
		byte protocol = receivePacket.getProtocol();		
		Object message = receivePacket.getMessage();
		Object sendMessage =null;
		Packet tempPacket = null;		
		switch (protocol) {
		case LOGIN:
			System.out.println("로그인  처리");
			sendMessage = sm.loginCheck(message);
			tempPacket = new Packet(POST, LOGIN, new TimeHandler().getTime(), sendMessage);
			break;
		case REG_ID_CHECK:
			System.out.println("아이디 중복확인 처리");
			sendMessage = sm.idCheck(message);
			tempPacket = new Packet(POST, REG_ID_CHECK, new TimeHandler().getTime(), sendMessage);
			break;
		case REG_USER:
			System.out.println("회원가입 처리");
			sendMessage = sm.addUser(message);
			tempPacket = new Packet(POST, REG_USER, new TimeHandler().getTime(), sendMessage);
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
