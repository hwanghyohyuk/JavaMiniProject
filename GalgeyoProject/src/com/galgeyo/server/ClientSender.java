package com.galgeyo.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.galgeyo.vo.Packet;

public class ClientSender implements Protocol {
	
	public Packet send(Packet sendPacket) {
		Socket socket = null;
		ObjectOutputStream oos = null;
		
		try {
			socket = new Socket("192.168.25.9", 6000);
			System.out.println("서버와의 연결 성공!");
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("패킷을 서버로 보냄 : "+sendPacket.toString());
			oos.writeObject(sendPacket);
			oos.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectInputStream ois = null;
		Packet receicvePacket = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			receicvePacket = (Packet) ois.readObject();
			System.out.println("서버로부터 받은 패킷 : " + receicvePacket.toString());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return receicvePacket;
	}

}
