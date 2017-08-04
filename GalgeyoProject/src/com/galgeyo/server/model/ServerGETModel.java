package com.galgeyo.server.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.galgeyo.server.DBsetting;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Menu;
import com.galgeyo.vo.MenuList;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.OrderList;
import com.galgeyo.vo.StoreList;

public class ServerGETModel implements DBsetting {

	public Object answerWaitList(Object message) {
		// TODO Auto-generated method stub
		ArrayList<Order> waitinglist = new ArrayList<Order>();
		String data = (String) message;// 아이디
		Properties waitingList = new Properties();
		try {
			waitingList.loadFromXML(new FileInputStream(WAITING_LIST+data+"_waitinglist.data"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = waitingList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = waitingList.getProperty(key);
			String[] values = value.split(",");
			Order order = new Order(values[0], values[1], values[2], values[3], values[4], values[5]);
			waitinglist.add(order);
		}
		OrderList array = new OrderList(waitinglist);
		return array;
	}

	public Object preOrderList(Object message) {
		ArrayList<Order> orderlist = new ArrayList<Order>();
		String data = (String) message;// 아이디
		Properties orderList = new Properties();
		try {
			orderList.loadFromXML(new FileInputStream(ORDER_LIST+data+"_orderlist.data"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<Object> iter = orderList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = orderList.getProperty(key);
			String[] values = value.split(",");
			Order order = new Order(values[0], values[1], values[2], values[3], values[4], values[5]);
			orderlist.add(order);
		}
		OrderList array = new OrderList(orderlist);
		return array;
	}

	public Object menuManagementList(Object message) {// 파라미터 값 매장 관리자 아이디
		String id = (String) message;
		ArrayList<Menu> menulist = new ArrayList<Menu>();

		Properties menuList = new Properties();
		try {
			menuList.loadFromXML(new FileInputStream(MENU_LIST + id + "_menulist.data"));
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

	public Object orderHistoryList(Object message) {
		ArrayList<Order> orderlist = new ArrayList<Order>();
		String data = (String) message;// 아이디
		Properties orderList = new Properties();
		try {
			orderList.loadFromXML(new FileInputStream(ORDER_LIST+data+"_orderlist.data"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = orderList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = orderList.getProperty(key);
			String[] values = value.split(",");
			Order order = new Order(values[0], values[1], values[2], values[3], values[4], values[5]);
			orderlist.add(order);
		}
		OrderList array = new OrderList(orderlist);
		return array;
	}

	public Object storeList(Object message) {
		ArrayList<Manager> storelist = new ArrayList<Manager>();
		String data = (String) message;
		Properties storeList = new Properties();
		try {
			storeList.loadFromXML(new FileInputStream(USER_TABLE));
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
		try {
			storeList.loadFromXML(new FileInputStream(USER_TABLE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Object> iter = storeList.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = storeList.getProperty(key);
			String[] values = value.split(",");
			if (!Boolean.parseBoolean(values[0])) {// 매장관리자
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
