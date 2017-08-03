package com.galgeyo.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class GalgeyoServer implements DBsetting {
	public void run() {
		/*
		 * Server Socket 생성 Client 연결 대기 > Socket 생성 Server Thread를 Start
		 * 클라이언트의 연결을 무한히 받는 부분
		 */
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			System.out.println("서버 정상 구동");
			/*최초실행시*/
			
			Properties firstRun = new Properties();
			try {
				firstRun.loadFromXML(new FileInputStream(USER_TABLE));		
				System.out.println("usertable 파일을 정상적으로 로드하였습니다.");
			} catch (FileNotFoundException e) {
				System.out.println("usertable 파일을 찾을수 없습니다. usertable 파일을 새로 생성합니다.");
				firstRun.storeToXML(new FileOutputStream(USER_TABLE), "","UTF-8");
				new GalgeyoServer().run();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			while (true) {
				Socket socket = serverSocket.accept();
				if (socket != null) {
					ServerReceiver serverThread = new ServerReceiver(socket);
					Thread thread = new Thread(serverThread);
					thread.start();
					ServerReceiverPool.add(serverThread);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
