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
	
<<<<<<< HEAD
	//세션.프로퍼티스 파일에서 불러오는 메소드
	public Object sessionLoad(){
=======
	public Object sessionLoad(){//세션.프로퍼티스 파일에서 불러오는 메소드
<<<<<<< HEAD
>>>>>>> a919f37adf48453acc7684fa6e25cb9638147c47
=======
>>>>>>> a919f37adf48453acc7684fa6e25cb9638147c47
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("session.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String session = prop.getProperty("session");
		String[] split = session.split(",");
<<<<<<< HEAD
<<<<<<< HEAD
		
		if(split[0].equals("true")){	//true면 사용자
			User user = new User(true, split[1], split[2], split[3], split[4]);
			Object temp=user;			
			return temp;
		}else{							//false면 관리자
=======
=======
>>>>>>> a919f37adf48453acc7684fa6e25cb9638147c47
		if(split[0].equals("true")){//true면 사용자
			User user = new User(true, split[1], split[2], split[3], split[4]);
			Object temp=user;			
			return temp;
		}else{//false면 관리자
<<<<<<< HEAD
>>>>>>> a919f37adf48453acc7684fa6e25cb9638147c47
=======
>>>>>>> a919f37adf48453acc7684fa6e25cb9638147c47
			Manager manager= new Manager(false, split[1], split[2], split[3], split[4], split[5], split[6], split[7]);
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
			e.printStackTrace();
		}
	}
}
