package com.galgeyo.server;

import java.io.*;
import java.net.*;
import java.util.Date;

import com.galgeyo.vo.Packet;

public class ClientMassgeReader implements Runnable, Protocol {
	// 서버로 부터 받는 부분
	private Socket socket;

	public ClientMassgeReader(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		ObjectInputStream ois = null;
		Packet receicvePacket = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			receicvePacket = (Packet) ois.readObject();
			System.out.println("server > " + receicvePacket.toString());
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

	}

}
