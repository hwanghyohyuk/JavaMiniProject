package com.galgeyo.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.User;

public class ServerPOSTModel implements DBsetting{

	// 로그인
	public Object loginCheck(Object message) {

		System.out.println("서버 모델 loginCheck 실행");

		Object sendMessage = null;
		// message : 로그인 시 필요한 아이디/비밀번호
		String[] data = null;
		if (message instanceof String) {
			data = ((String) message).split("/");
		}
		String receiveId = data[0];
		String receivePw = data[1];

		System.out.println("받은 메시지 내용 : " + message);

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
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
				if (receivePw.equals(pwd)) {// 아이디, 패스워드 매치
					if (isUser) {// 사용자
						sendMessage = new User(isUser, id, pwd, name, tel);
						break;
					} else {// 매장관리자
						String ownNo = values[5];
						String addr = values[6];
						String type = values[7];
						boolean isOpen = Boolean.parseBoolean(values[8]);
						sendMessage = new Manager(isUser, id, pwd, name, tel, ownNo, addr, type, isOpen);
						break;
					}
				} else {
					sendMessage = true;
					break;
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

	// 아이디 중복확인
	public Object idCheck(Object message) {

		System.out.println("서버 모델 idCheck 실행");

		Object sendMessage = null;
		// message : 로그인 시 필요한 아이디/비밀번호
		String data = ((String) message);

		System.out.println("받은 메시지 내용 : " + data);

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
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

	// 회원가입
	public Object addUser(Object message) {
		System.out.println("서버 모델 addUser 실행");
		User user = null;
		Manager manager = null;
		Object sendMessage = null;
		// message : 로그인 시 필요한 아이디/비밀번호

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (message instanceof User) {
			System.out.println("받은 메시지 내용 : " + ((User) message).toString());
			user = (User) message;
			UserTable.setProperty(user.getId(), user.toString());
			Properties favoriteList = new Properties();
			Properties orderList = new Properties();
			
			try {
				favoriteList.store(new FileWriter(FAVORITE_LIST+user.getId()+"_favorite.properties"), "new file");
				orderList.store(new FileWriter(ORDER_LIST+user.getId()+"_orderlist.properties"),  "new file");
				System.out.println("User용 파일 추가");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} else if (message instanceof Manager) {
			System.out.println("받은 메시지 내용 : " + ((Manager) message).toString());
			manager = (Manager) message;
			UserTable.setProperty(manager.getId(), manager.toString());
			Properties menulist = new Properties();
			Properties orderList = new Properties();
			Properties waitinList = new Properties();
			Properties bookingList = new Properties();
			try {
				menulist.store(new FileWriter(MENU_LIST+manager.getId()+"_menulist.properties"), "new file");
				orderList.store(new FileWriter(ORDER_LIST+manager.getId()+"_orderlist.properties"),  "new file");
				waitinList.store(new FileWriter(WAITING_LIST+manager.getId()+"_waitinglist.properties"), "new file");
				bookingList.store(new FileWriter(BOOKING_LIST+manager.getId()+"_bookinglist.properties"),  "new file");
				System.out.println("Manager용 파일 추가");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			UserTable.store(new FileWriter(USER_TABLE), "user add");
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
	//
	public Object changeReserStatus(Object message) {

		Object sendMessage = null;
		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(message instanceof Manager){
			Manager manager = (Manager)message;
			boolean Switch = manager.isOpen();
			manager.setOpen(!Switch);
			UserTable.remove(manager.getId());
			UserTable.setProperty(manager.getId(), manager.toString());		
			sendMessage= manager.isOpen();
		}		
		try {
			UserTable.store(new FileWriter(USER_TABLE), "changeReserStatus");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendMessage;
	}

	// 아이디 찾기
	public Object findId(Object message) {
		Object sendMessage = null;
		// message : 아이디 찾기 시 필요한 이름/전화번호
		String[] data = null;
		if (message instanceof String) {
			data = ((String) message).split(",");
		}
		String receiveName = data[0];
		String receiveTel = data[1];

		System.out.println("받은 메시지 내용 : " + message);

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<Entry<Object, Object>> iter = UserTable.entrySet().iterator();
		while (iter.hasNext()) {
			// key는 id
			// value는 객체
			Entry<Object, Object> entry = iter.next();
			String value = (String) entry.getValue();
			String[] values = value.split(",");
			String id = values[1];
			String name = values[3];
			String tel = values[4];

			if (receiveName.equals(name)) {// 이름 매치
				if (receiveTel.equals(tel)) {// 이름,전화번호 매치
					sendMessage = id;
					break;
				} else {
					sendMessage = null;
				}
			} else {
				sendMessage = null;
			}
		}
		System.out.println("아이디 찾기 처리 결과 : " + sendMessage);

		return sendMessage;
	}

	// 패스워드 찾기
	public Object findPw(Object message) {
		Object sendMessage = null;
		// message : 비밀번호 변경 시 필요한 아이디/비밀번호
		String[] data = null;
		if (message instanceof String) {
			data = ((String) message).split(",");
		}
		String receiveId = data[0];
		String receiveTel = data[1];

		System.out.println("받은 메시지 내용 : " + message);

		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<Entry<Object, Object>> iter = UserTable.entrySet().iterator();
		while (iter.hasNext()) {
			// value는 객체
			Entry<Object, Object> entry = iter.next();
			String value = (String) entry.getValue();
			String[] values = value.split(",");
			String id = values[1];
			String tel = values[4];

			if (receiveId.equals(id)) {// 아이디 매치
				if (receiveTel.equals(tel)) {// 아이디,전화번호 매치
					sendMessage = true;
					break;
				} else {
					sendMessage = false;
				}
			} else {
				sendMessage = false;
			}
		}
		System.out.println("비밀번호 찾기 처리 결과 : " + sendMessage);
		return sendMessage;
	}

	public Object modifyPw(Object message) {
		Object sendMessage = null;
		Object temp = null;
		// message : 비밀번호 찾기 시 필요한 아이디/전화번호
		String[] data = null;
		if (message instanceof String) {
			data = ((String) message).split("/");
		}
		String receiveId = data[0];
		String receivePw = data[1];
		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Properties UserTableClone = (Properties) UserTable.clone();
		Iterator<Entry<Object, Object>> iter = UserTableClone.entrySet().iterator();
		while (iter.hasNext()) {
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
			String ownNo = null;
			String addr = null;
			String type = null;
			boolean isOpen = false;
			if (receiveId.equals(id)) {// 아이디 매치
				UserTable.remove(key);
				if (isUser) {// 사용자
					temp = new User(isUser, id, receivePw, name, tel);
					UserTable.setProperty(key, ((User) temp).toString());
				} else {// 매장관리자
					ownNo = values[5];
					addr = values[6];
					type = values[7];
					isOpen = Boolean.getBoolean(values[8]);
					temp = new Manager(isUser, id, receivePw, name, tel, ownNo, addr, type, isOpen);
					UserTable.setProperty(key, ((Manager) temp).toString());
				}
				try {
					UserTable.store(new FileWriter(USER_TABLE), "modify password");
				} catch (IOException e) {
					e.printStackTrace();
				}
				sendMessage = true;
				break;
			} else {
				sendMessage = false;
			}
		}

		System.out.println("비밀번호 변경 처리 결과 : " + sendMessage);
		return sendMessage;
	}

	public Object editUserInfo(Object message) {
		Object sendMessage = null;
		System.out.println("받은 메시지 내용 : " + message.toString());
		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Properties UserTableClone = (Properties) UserTable.clone();
		Iterator<Entry<Object, Object>> iter = UserTableClone.entrySet().iterator();
		while (iter.hasNext()) {
			// value는 객체
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			if (message instanceof Manager) {// 객체에따라
				if (key.equals(((Manager) message).getId())) {
					UserTable.remove(key);
					UserTable.setProperty(key, ((Manager) message).toString());
					sendMessage = true;
					break;
				} else {
					sendMessage = false;
				}
			} else if (message instanceof User) {
				if (key.equals(((User) message).getId())) {
					UserTable.remove(key);
					UserTable.setProperty(key, ((User) message).toString());
					sendMessage = true;
					break;
				} else {
					sendMessage = false;
				}
			} else {
				System.out.println("받은 메시지 내용 : " + message);
			}
		}
		try {
			UserTable.store(new FileWriter(USER_TABLE), "modify user info");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sendMessage==null) {
			sendMessage = false;
		}
		return sendMessage;
	}

	public Object addMenu(Object message) {
		Object sendMessage = true;
		boolean check = false;
		String[] data = null;
		if (message instanceof String) {
			data = ((String) message).split("/");
		}
		String receiveId = data[0];
		String receiveMenu = data[1];
		String[] menu = receiveMenu.split(",");
		Properties menuList = new Properties();
			
		try {
			menuList.load(new FileReader(MENU_LIST+receiveId+"_menulist.properties"));
		}catch(FileNotFoundException e){
			try {
				menuList.store(new FileWriter(MENU_LIST+receiveId+"_menulist.properties"), "file create");
				menuList.setProperty(menu[0], receiveMenu);
				menuList.store(new FileWriter(MENU_LIST+receiveId+"_menulist.properties"), "file create");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<Entry<Object, Object>> iter = menuList.entrySet().iterator();
		while (iter.hasNext()) {
			// value는 객체
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			if(key.equals(menu[0])){
				check = true;
				break;
			}		
		}
		if(check){
			sendMessage = false;
		}else{
			sendMessage=true;
			menuList.setProperty(menu[0], receiveMenu);
		}
		try {
			menuList.store(new FileWriter(MENU_LIST+receiveId+"_menulist.properties"), "menu add");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return sendMessage;
	}

	public Object acceptOrder(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object acceptCancel(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object deleteMenu(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object delThisFavor(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object delThisRecent(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object orderMenu(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

}
