package com.galgeyo.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.galgeyo.vo.Packet;

public class ClientSender implements Protocol {
	private Packet sendPacket;
	public ClientSender(Packet sendPacket){
		this.sendPacket = sendPacket;
	}
	
	public void run() {
		Socket socket = null;
		ObjectOutputStream oos = null;
		
		try {
			socket = new Socket("192.168.25.9", 6000);
			System.out.println("서버와의 연결 성공!");
			
			// 서버로부터 메시지를 받는 쓰레드 생성
			ClientReceiver packetReceiver = new ClientReceiver(socket);
			Thread threadReceiver = new Thread(packetReceiver);
			threadReceiver.start();		
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			Object str = null;
			sendPacket = new Packet(true, LOGIN, new TimeHandler().getTime(), str);
			oos.writeObject(sendPacket);
			oos.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
