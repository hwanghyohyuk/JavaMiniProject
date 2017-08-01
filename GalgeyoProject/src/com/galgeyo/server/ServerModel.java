package com.galgeyo.server;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.User;

public class ServerModel {

	public Object loginCheck(Object message) {
		System.out.println("서버 모델 실행");
		Object sendMessage=null;
		//message : 로그인 시 필요한 아이디/비밀번호
		String[] data = null;
		if(message instanceof String){
			data = ((String) message).split("/");
		}
		String receiveId=data[0];
		String receivePwd = data[1];
		
		System.out.println("받은 메시지 내용 : "+message);
				
		Properties UserTable = new Properties();
		try {
			UserTable.load(new FileReader("usertable.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<Entry<Object, Object>> iter = UserTable.entrySet().iterator();
		while(iter.hasNext()){
			//key는 id
			//value는 객체
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			String[] values = value.split(",");
			boolean isUser = Boolean.getBoolean(values[0]);
			String id = values[1];
			String pwd = values[2];
			String name = values[3];
			String tel = values[4];
			
			if(isUser){//사용자
				if(receiveId.equals(id)){//아이디 매치
					if(receivePwd.equals(pwd)){//아이디, 패스워드 매치
						sendMessage = new User(isUser, id, pwd, name, tel);
					}else{
						sendMessage = true;
					}					
				}else{
					sendMessage = false;
				}				
			}else{//매장관리자
				if(receiveId.equals(id)){
					if(receivePwd.equals(pwd)){
						String ownNo = values[5];
						String addr = values[6];
						String type = values[7];
						boolean isOpen = Boolean.getBoolean(values[8]);
						sendMessage = new Manager(isUser, id, receivePwd, name, tel, ownNo, addr, type, isOpen);
					}else{
						sendMessage = true;
					}
				}else{
					sendMessage = false;
				}
			}			
		}
		if(sendMessage==null){
			sendMessage=false;
		}
		System.out.println("로그인 처리 결과 : "+sendMessage);
		return sendMessage;
	}
}
