package com.galgeyo.server;

import com.galgeyo.vo.Packet;

public class ServerGETController implements Protocol{
	
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
		case ANSWER_WAIT_LIST:
			break;
		case PRE_ODER_LIST:
			break;
		case MENU_MANAGEMENT_LIST:
			break;
		case ORDER_HISTORY_STATISTICS:
			break;
		case FAVORITES_LIST :
			break;
		case ORDER_HISTORY_LIST :
			break;
		case STORE_LIST :
			break;
		case STORE_MENU_LIST :
			break;		
		}

		Packet sendPacket = null;
		return sendPacket;
	}
}
