package com.galgeyo.server;

import java.io.*;
import java.net.*;

import com.galgeyo.vo.Packet;

public class ServerThread implements Runnable, Protocol {

	/*
	 * Thread 클래스 Socket을 받아 그에 연결된 클라이언트가 보내는 패킷을 분석하여 작업을 진행한다. Server의 패킷을 받는
	 * 부분
	 */

	private Socket socket;

	public ServerThread(Socket socket) {
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

			Packet sendPacket = null;
			if (receivePacket.isHeader()) {// true면 POST작업 처리
				System.out.println(receivePacket.toString());
				sendPacket = new Packet(receivePacket.isHeader(), LOGIN_SUCCESS, new TimeHandler().getTime(), null);
				try {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(sendPacket);
					oos.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {// false면 GET작업 처리
				/*
				 * System.out.println(inpacket.toString()); sendPacket = new
				 * Packet(inpacket.isHeader(), LOGIN_SUCCESS, new
				 * TimeHandler(new Date()).getTime(), null);
				 */
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
