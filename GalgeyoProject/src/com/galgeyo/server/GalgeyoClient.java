package com.galgeyo.server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class GalgeyoClient {

	public static void run() {
		Socket socket = null;
		try {
			socket = new Socket("192.168.25.9", 6000);
			System.out.println("서버와의 연결 성공!");

			// 서버로부터 메시지를 받는 쓰레드 생성
			ClientReceiver packetReceiver = new ClientReceiver(socket);
			Thread threadReceiver = new Thread(packetReceiver);
			ClientSender packetSender = new ClientSender(socket);
			Thread threadSender = new Thread(packetReceiver);
			threadReceiver.start();
			threadSender.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
