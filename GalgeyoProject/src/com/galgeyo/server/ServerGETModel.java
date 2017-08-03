package com.galgeyo.server;

import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Menu;
import com.galgeyo.vo.MenuList;
import com.galgeyo.vo.StoreList;

public class ServerGETModel implements DBsetting {

	public Object answerWaitList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object preOrderList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object menuManagementList(Object message) {// 파라미터 값 매장 관리자 아이디
		String id = (String) message;
		ArrayList<Menu> menulist = new ArrayList<Menu>();

		Properties menuList = new Properties();
		try {
			menuList.load(new FileReader(MENU_LIST + id + "_menulist.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = menuList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = menuList.getProperty(key);
			String[] values = value.split(",");
			Menu menu = new Menu(values[0], values[1], values[2], Integer.parseInt(values[3]),
					Double.parseDouble(values[4]), Boolean.parseBoolean(values[5]));
			menulist.add(menu);
		}
		MenuList array = new MenuList(menulist);
		return array;
	}

	public Object orderHistoryStatistics(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object favoritesList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object orderHistoryList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object storeList(Object message) {
		ArrayList<Manager> storelist = new ArrayList<Manager>();
		String data = (String) message;
		Properties storeList = new Properties();
		try {
			storeList.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = storeList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = storeList.getProperty(key);
			String[] values = value.split(",");
			if (!Boolean.parseBoolean(values[0])) {
				Manager store = new Manager(Boolean.parseBoolean(values[0]), values[1], values[2], values[3], values[4],
						values[5], values[6], values[7], Boolean.parseBoolean(values[8]));
				if (store.getType().equals(data)) {
					if (store.isOpen()) {
						storelist.add(store);
					}
				}
			}
		}
		StoreList array = new StoreList(storelist);
		return array;
	}

	public Object storeMenuList(Object message) {
		String data = (String) message;
		Properties storeList = new Properties();
		Properties menuList = new Properties();
		ArrayList<Menu> menulist = new ArrayList<Menu>();
		try {
			storeList.load(new FileReader(USER_TABLE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = storeList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = storeList.getProperty(key);
			String[] values = value.split(",");
			if (!Boolean.parseBoolean(values[0])) {//매장관리자
				Manager store = new Manager(Boolean.parseBoolean(values[0]), values[1], values[2], values[3], values[4],
						values[5], values[6], values[7], Boolean.parseBoolean(values[8]));
				if (store.getName().equals(data)) {
					return menuManagementList(key);
				}
			}
		}
		return null;
	}

}
