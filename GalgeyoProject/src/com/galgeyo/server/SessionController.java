package com.galgeyo.server;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.User;

public class SessionController {
	
	public Object sessionLoad(){//세션.프로퍼티스 파일에서 불러오는 메소드
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("session.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String session = prop.getProperty("session");
		String[] split = session.split(",");
		if(split[0].equals("true")){//true면 사용자
			User user = new User(true, split[1], split[2], split[3], split[4]);
			Object temp=user;			
			return temp;
		}else{//false면 관리자
			Manager manager= new Manager(false, split[1], split[2], split[3], split[4], split[5], split[6], split[7],Boolean.parseBoolean(split[8]));
			Object temp=manager;
			return temp;
		}		
	}
	
	public void sessionSave(Object obj){
		Properties prop = new Properties();
		if(obj instanceof Manager){
			prop.setProperty("session", ((Manager)obj).toString());
		}else if(obj instanceof User){
			prop.setProperty("session", ((User)obj).toString());
		}
		try {
			prop.store(new FileOutputStream("session.properties"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public int menuSelectOpen(){
		Properties prop = new Properties();
		String menu=null;
		try {
			prop.load(new FileInputStream("session.properties"));
			menu = prop.getProperty("selectedMenu");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.parseInt(menu);
	}
	
	public void menuSelectSave(int menuNo){
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("session.properties"));
			prop.setProperty("selectedMenu", String.valueOf(menuNo));
			prop.store(new FileOutputStream("session.properties"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void deleteSession(Session session) {
		session.setSession(null);
		Properties prop = new Properties();
		try {
			prop.store(new FileOutputStream("session.properties"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
