package com.galgeyo.server;

import java.io.*;
import java.net.Socket;

import com.galgeyo.vo.Packet;

public class ClientSender implements Runnable, Protocol {
	private Socket socket;
	
	public ClientSender(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			Object str = null;
			Packet sendPacket = new Packet(true, LOGIN, new TimeHandler().getTime(), str);
			oos.writeObject(sendPacket);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
