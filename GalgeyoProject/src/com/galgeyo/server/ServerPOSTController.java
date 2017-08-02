package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ServerPOSTController implements Protocol {
	private ServerPOSTModel sm = new ServerPOSTModel();
	/*
	 * ServerThread에서 받은 데이터를 분석하여 모델에 전달이 필요하면 전달 반환값은 Packet
	 */

	// sendPacket = new Packet(receivePacket.isHeader(), LOGIN_SUCCESS, new
	// TimeHandler().getTime(), null);

	public Packet POSTprocess(Packet receivePacket) {
		System.out.println("서버 컨트롤러 POST process 실행");
		byte protocol = receivePacket.getProtocol();
		Object message = receivePacket.getMessage();
		Object sendMessage = null;
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
		case FIND_ID:
			System.out.println("아이디 찾기 처리");
			sendMessage = sm.findId(message);
			tempPacket = new Packet(POST, FIND_PW, new TimeHandler().getTime(), sendMessage);
			break;
		case FIND_PW:
			System.out.println("패스워드 찾기 처리");
			sendMessage = sm.findPw(message);
			tempPacket = new Packet(POST, FIND_PW, new TimeHandler().getTime(), sendMessage);
			break;
		case MODIFY_PASSWORD:
			System.out.println("비밀번호 변경 처리");
			sendMessage = sm.modifyPw(message);
			tempPacket = new Packet(POST, FIND_PW, new TimeHandler().getTime(), sendMessage);
			break;
		}

		System.out.println("서버 컨트롤러 종료");

		Packet sendPacket = tempPacket;
		return sendPacket;
	}
}
