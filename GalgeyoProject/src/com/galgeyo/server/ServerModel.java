package com.galgeyo.server;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.User;

public class ServerModel {

	public Object loginCheck(Object message) {

		System.out.println("서버 모델 loginCheck 실행");

		Object sendMessage = null;
		// message : 로그인 시 필요한 아이디/비밀번호
		String[] data = null;
		if (message instanceof String) {
			data = ((String) message).split("/");
		}
		String receiveId = data[0];
		String receivePwd = data[1];

		System.out.println("받은 메시지 내용 : " + message);

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader("usertable.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<Entry<Object, Object>> iter = UserTable.entrySet().iterator();
		while (iter.hasNext()) {
			// key는 id
			// value는 객체
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			String[] values = value.split(",");
			boolean isUser = Boolean.parseBoolean(values[0]);
			String id = values[1];
			String pwd = values[2];
			String name = values[3];
			String tel = values[4];

			if (receiveId.equals(id)) {// 아이디 매치
				if (receivePwd.equals(pwd)) {// 아이디, 패스워드 매치
					if (isUser == true) {// 사용자
						sendMessage = new User(isUser, id, pwd, name, tel);
						break;
					} else {// 매장관리자
						String ownNo = values[5];
						String addr = values[6];
						String type = values[7];
						boolean isOpen = Boolean.getBoolean(values[8]);
						sendMessage = new Manager(isUser, id, receivePwd, name, tel, ownNo, addr, type, isOpen);
						break;
					}
				} else {
					sendMessage = true;
				}
			} else {
				sendMessage = false;
			}
		}
		if (sendMessage == null) {
			sendMessage = false;
		}
		System.out.println("로그인 처리 결과 : " + sendMessage);

		return sendMessage;
	}

	public Object idCheck(Object message) {

		System.out.println("서버 모델 idCheck 실행");

		Object sendMessage = null;
		// message : 로그인 시 필요한 아이디/비밀번호
		String data = ((String) message);

		System.out.println("받은 메시지 내용 : " + data);

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader("usertable.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator iter = UserTable.keySet().iterator();
		while (iter.hasNext()) {
			// key는 id
			String key = (String) iter.next();
			if (key.equals(data)) {// 아이디 매치
				sendMessage = true;
				break;
			} else {
				sendMessage = false;
			}
		}
		if (sendMessage == null) {
			sendMessage = false;
		}
		System.out.println("아이디 중복확인 처리 결과 : " + sendMessage);

		return sendMessage;
	}

	public Object addUser(Object message) {
		System.out.println("서버 모델 addUser 실행");
		User user = null;
		Manager manager = null;
		Object sendMessage = null;
		// message : 로그인 시 필요한 아이디/비밀번호

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader("usertable.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (message instanceof User) {
			System.out.println("받은 메시지 내용 : " + ((User) message).toString());
			user = (User) message;
			UserTable.setProperty(user.getId(), user.toString());
		} else if (message instanceof Manager) {
			System.out.println("받은 메시지 내용 : " + ((Manager) message).toString());
			manager = (Manager) message;
			UserTable.setProperty(manager.getId(), manager.toString());
		}
		try {
			UserTable.store(new FileWriter("usertable.properties"), "user add");
			sendMessage = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sendMessage == null) {
			sendMessage = false;
		}
		System.out.println("회원가입 처리 결과 : " + sendMessage);

		return sendMessage;
	}

}
