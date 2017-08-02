package com.galgeyo.controller;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.User;

public class SessionController {
	
	// 사용자 정의 패킷
		// 패킷은 boolean,byte,Date,String 순서로 객체화된다
		// 패킷에 필요한 정보를 담고 객체스트림으로 입출력한다.
	
	public Object sessionLoad(){//세션.프로퍼티스 파일에서 불러오는 메소드
		System.out.println("exe");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("session.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String session = prop.getProperty("session");
		System.out.println(session);
		String[] split = session.split(",");
		for(String s : split){
			System.out.println(s);
		}
		if(split[0].equals("true")){//true면 사용자
			System.out.println("true");
			User user = new User(true, split[1], split[2], split[3], split[4]);
			Object temp=user;			
			return temp;
		}else{//false면 관리자
			System.out.println("false");
			Manager manager= new Manager(false, split[1], split[2], split[3], split[4], split[5], split[6], split[7],Boolean.getBoolean(split[8]));
			Object temp=manager;
			return temp;
		}		
	}
	
	public void sessionSave(Object obj){
		Properties prop = new Properties();
		if(obj instanceof User){
			prop.setProperty("session", ((User)obj).toString());
		}else if(obj instanceof Manager)
		prop.setProperty("session", ((Manager)obj).toString());
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
	
	
}
