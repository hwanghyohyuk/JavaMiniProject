package com.galgeyo.server;

import java.util.*;

public class ServerReceiverPool {

	public static ArrayList<ServerReceiver> clientList = new ArrayList<ServerReceiver>();

	public static void add(ServerReceiver thread) {
		clientList.add(thread);
		System.out.println("클라이언트 접속");
	}

	public static void remove(ServerReceiver thread) {
		clientList.remove(thread);
		System.out.println("클라이언트 접속해제");
	}
}
