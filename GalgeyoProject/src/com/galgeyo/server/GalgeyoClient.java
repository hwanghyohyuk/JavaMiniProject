package com.galgeyo.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.galgeyo.vo.Packet;

public class GalgeyoClient implements Protocol{

	// 서버로 쓰기만
		public static void run() {
			Socket socket = null;

			BufferedReader bufferedReader = null;
			ObjectOutputStream oos = null;

			try {
				socket = new Socket("192.168.25.9", 6000);
				System.out.println("서버와의 연결 성공!");

				// 서버로부터 메시지를 받는 쓰레드 생성
				ClientMassgeReader packetReader = new ClientMassgeReader(socket);
				Thread thread = new Thread(packetReader);
				thread.start();
				bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				oos = new ObjectOutputStream(socket.getOutputStream());
				String str = bufferedReader.readLine();
					if (str.equals("") || str.equals("exit")) {
						System.out.println("연결이 종료되었습니다.");
						return;
					}
					Packet sendPacket = new Packet(true, LOGIN, new TimeHandler().getTime(), str);
					oos.writeObject(sendPacket);
					oos.flush();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /*finally {
				try {
					oos.close();
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}


}
