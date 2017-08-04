package com.galgeyo.server.controller;

import com.galgeyo.server.Protocol;
import com.galgeyo.server.model.ServerGETModel;
import com.galgeyo.vo.Packet;

public class ServerGETController implements Protocol{
	
	private ServerGETModel sm = new ServerGETModel();
	/*
	 * ServerThread에서 받은 데이터를 분석하여 모델에 전달이 필요하면 전달 반환값은 Packet
	 */

	// sendPacket = new Packet(receivePacket.isHeader(), LOGIN_SUCCESS, new
	// TimeHandler().getTime(), null);
	
	public Packet GETprocess(Packet receivePacket) {
		byte protocol = receivePacket.getProtocol();
		Object message = receivePacket.getMessage();
		Object sendMessage = null;
		Packet tempPacket = null;
		switch (protocol) {
		case ANSWER_WAIT_LIST:
			System.out.println("응답대기자 리스트 반환 처리");
			sendMessage = sm.answerWaitList(message);
			tempPacket = new Packet(GET, ANSWER_WAIT_LIST, new TimeHandler().getTime(), sendMessage);
			break;
		case ORDER_LIST:
			System.out.println("예약주문자 리스트 반환 처리");
			sendMessage = sm.preOrderList(message);
			tempPacket = new Packet(GET, ORDER_LIST, new TimeHandler().getTime(), sendMessage);
			break;
		case MENU_MANAGEMENT_LIST:
			System.out.println("메뉴관리 리스트 반환 처리");
			sendMessage = sm.menuManagementList(message);
			tempPacket = new Packet(GET, MENU_MANAGEMENT_LIST, new TimeHandler().getTime(), sendMessage);
			break;
		case ORDER_HISTORY_LIST:
			System.out.println("사용자 최근주문내역 리스트 반환 처리");
			sendMessage = sm.orderHistoryList(message);
			tempPacket = new Packet(GET, ORDER_HISTORY_LIST, new TimeHandler().getTime(), sendMessage);
			break;
		case STORE_LIST:
			System.out.println("매장 리스트 반환 처리");
			sendMessage = sm.storeList(message);
			tempPacket = new Packet(GET, STORE_LIST, new TimeHandler().getTime(), sendMessage);
			break;
		case STORE_MENU_LIST:
			System.out.println("매장 메뉴 리스트 반환 처리");
			sendMessage = sm.storeMenuList(message);
			tempPacket = new Packet(GET, STORE_MENU_LIST, new TimeHandler().getTime(), sendMessage);
			break;		
		}

		Packet sendPacket = tempPacket;
		return sendPacket;
	}
}
