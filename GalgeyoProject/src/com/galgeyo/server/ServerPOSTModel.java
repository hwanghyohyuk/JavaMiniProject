package com.galgeyo.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.User;

public class ServerPOSTModel implements DBsetting {

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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
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

			if (receiveId.equals(key)) {// 아이디 매치
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (message instanceof Manager) {
			System.out.println("받은 메시지 내용 : " + ((Manager) message).toString());
			manager = (Manager) message;
			UserTable.setProperty(manager.getId(), manager.toString());
			Properties menulist = new Properties();
			Properties orderList = new Properties();
			Properties waitinList = new Properties();
			Properties bookingList = new Properties();
			try {
				menulist.storeToXML(new FileOutputStream(MENU_LIST + manager.getId() + "_menulist.data"), "new file",
						"UTF-8");
				orderList.storeToXML(new FileOutputStream(ORDER_LIST + manager.getId() + "_orderlist.data"), "new file",
						"UTF-8");
				waitinList.storeToXML(new FileOutputStream(WAITING_LIST + manager.getId() + "_waitinglist.data"),
						"new file", "UTF-8");
				System.out.println("Manager용 파일 추가");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (message instanceof User) {
			System.out.println("받은 메시지 내용 : " + ((User) message).toString());
			user = (User) message;
			UserTable.setProperty(user.getId(), user.toString());
			Properties favoriteList = new Properties();
			Properties orderList = new Properties();

			try {
				orderList.storeToXML(new FileOutputStream(ORDER_LIST + user.getId() + "_orderlist.data"), "new file",
						"UTF-8");
				System.out.println("User용 파일 추가");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			UserTable.storeToXML(new FileOutputStream(USER_TABLE), "add user", "UTF-8");
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (message instanceof Manager) {
			Manager manager = (Manager) message;
			boolean Switch = manager.isOpen();
			manager.setOpen(!Switch);
			UserTable.remove(manager.getId());
			UserTable.setProperty(manager.getId(), manager.toString());
			sendMessage = manager.isOpen();
		}
		try {
			UserTable.storeToXML(new FileOutputStream(USER_TABLE), "changeReserStatus", "UTF-8");
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
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
					UserTable.storeToXML(new FileOutputStream(USER_TABLE), "modify password", "UTF-8");
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
			UserTable.loadFromXML(new FileInputStream(USER_TABLE));
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
			UserTable.storeToXML(new FileOutputStream(USER_TABLE), "modify user info", "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sendMessage == null) {
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
			menuList.loadFromXML(new FileInputStream(MENU_LIST + receiveId + "_menulist.data"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Iterator<Entry<Object, Object>> iter = menuList.entrySet().iterator();
		while (iter.hasNext()) {
			// value는 객체
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			if (key.equals(menu[0])) {
				check = true;
				break;
			}
		}
		if (check) {
			sendMessage = false;
		} else {
			sendMessage = true;
			menuList.setProperty(menu[0], receiveMenu);
		}
		try {
			menuList.storeToXML(new FileOutputStream(MENU_LIST + receiveId + "_menulist.data"), "menu add", "UTF-8");
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
		Object sendMessage = true;
		String[] data = ((String) message).split(",");
		String receiveMenuNo = data[0];
		String receiveId = data[1];
		Properties menuList = new Properties();
		try {
			menuList.loadFromXML(new FileInputStream(MENU_LIST + receiveId + "_menulist.data"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuList.remove(receiveMenuNo);
		try {

			menuList.storeToXML(new FileOutputStream(MENU_LIST + receiveId + "_menulist.data"), "delete menu", "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendMessage;
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
		Order order = (Order) message;
		String[] data = order.toString().split(",");
		String desStore = data[0];
		String desStoreId = null;
		String userName = data[2];
		String userId = null;
		// data[5]=주문한 메뉴리스트
		Properties userTable = new Properties();
		try {
			userTable.loadFromXML(new FileInputStream(USER_TABLE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = userTable.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = userTable.getProperty(key);
			String[] values = value.split(",");
			if (!Boolean.parseBoolean(values[0])) {// 매장관리자
				Manager store = new Manager(Boolean.parseBoolean(values[0]), values[1], values[2], values[3], values[4],
						values[5], values[6], values[7], Boolean.parseBoolean(values[8]));
				if (store.getName().equals(desStore)) {
					desStoreId = key;
				}
			} else {// 일반 사용자
				User user = new User(Boolean.parseBoolean(values[0]), values[1], values[2], values[3], values[4]);
				if (user.getName().equals(userName)) {
					userId = key;
				}
			}
		}
			if (desStoreId != null && userId != null) {
				Properties storeOrder = new Properties();
				Properties userOrder = new Properties();
				try {
					storeOrder.loadFromXML(new FileInputStream(WAITING_LIST + desStoreId + "_waitinglist.data"));
					userOrder.loadFromXML(new FileInputStream(ORDER_LIST + userId + "_orderlist.data"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				storeOrder.setProperty(order.getOrderNo(), order.toString());
				userOrder.setProperty(order.getOrderNo(), order.toString());

				try {
					storeOrder.storeToXML(new FileOutputStream(WAITING_LIST + desStoreId + "_waitinglist.data"),
							"add order", "UTF-8");
					userOrder.storeToXML(new FileOutputStream(ORDER_LIST + userId + "_orderlist.data"), "add order",
							"UTF-8");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		return false;
	}
}
