package com.galgeyo.server;

import java.io.*;
import java.net.*;
import java.util.Properties;

import com.galgeyo.server.controller.ServerGETController;
import com.galgeyo.server.controller.ServerPOSTController;
import com.galgeyo.vo.Packet;

public class ServerReceiver implements Runnable, Protocol {

	/*
	 * Thread 클래스 Socket을 받아 그에 연결된 클라이언트가 보내는 패킷을 분석하여 작업을 진행한다. Server의 패킷을 받는
	 * 부분
	 */

	private Socket socket;
	private ServerPOSTController postCon = new ServerPOSTController();
	private ServerGETController getCon = new ServerGETController();
	
	public ServerReceiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Packet receivePacket = null;
	
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			receivePacket = (Packet) ois.readObject();

			System.out.println("클라이언트로 부터 받은 패킷 : " + receivePacket.toString());
			
			Packet sendPacket = null;
			if (receivePacket.isHeader()) {// true면 POST작업 처리
				
				sendPacket = postCon.POSTprocess(receivePacket);				
				try {
					oos = new ObjectOutputStream(socket.getOutputStream());
					System.out.println("클라이언트로 보낼 패킷 : "+sendPacket.toString());
					oos.flush();
					oos.writeObject(sendPacket);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {// false면 GET작업 처리
				System.out.println(receivePacket.toString());
				sendPacket = getCon.GETprocess(receivePacket);				
				try {
					oos = new ObjectOutputStream(socket.getOutputStream());
					System.out.println("클라이언트로 보낼 패킷 : "+sendPacket.toString());
					oos.flush();
					oos.writeObject(sendPacket);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			ServerReceiverPool.remove(this);
			if(socket!=null)
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
