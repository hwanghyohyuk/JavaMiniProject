package com.galgeyo.server;

import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.galgeyo.vo.Menu;

public class ServerGETModel implements DBsetting {

	public Object answerWaitList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object preOrderList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object menuManagementList(Object message) {//파라미터 값 매장 관리자 아이디
		String id = (String)message;
		ArrayList<Menu> menulist = new ArrayList<Menu>();
		Properties menuList= new Properties();
		try {
			menuList.load(new FileReader(MENU_LIST+id+"_menulist.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set set =  menuList.entrySet();
		Iterator<> iter = set.iterator();
		
		
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	public Object storeMenuList(Object message) {
		// TODO Auto-generated method stub
		return null;
	}

}
