package com.galgeyo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GalgeyoServer {
	public void run() {
		/*
		 * Server Socket 생성 Client 연결 대기 > Socket 생성 Server Thread를 Start
		 * 클라이언트의 연결을 무한히 받는 부분
		 */
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			System.out.println("서버 정상 구동!");
			while (true) {
				Socket socket = serverSocket.accept();
				if (socket != null) {
					ServerThread serverThread = new ServerThread(socket);
					Thread thread = new Thread(serverThread);
					thread.start();
					ServerThreadPool.add(serverThread);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
