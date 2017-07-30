package com.galgeyo.server;

import java.util.*;

public class ServerThreadPool {

	public static ArrayList<ServerThread> clientList = new ArrayList<ServerThread>();

	public static void add(ServerThread thread) {
		clientList.add(thread);
		System.out.println("클라이언트풀 추가!");
	}

	public static void remove(ServerThread thread) {
		clientList.remove(thread);
		System.out.println("클라이언트풀 제거!");
	}
}
