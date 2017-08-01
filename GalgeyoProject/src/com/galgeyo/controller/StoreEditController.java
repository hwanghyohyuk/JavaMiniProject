package com.galgeyo.controller;

import com.galgeyo.view.ManagerMainView;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;

public class StoreEditController {
	// 변경사항 제출 후 메인으로이동
		public void submitInfo(String name,String ownNo, String tel, String addr, String type, String pwd, Session manager) {
			boolean result = false;
				
			// 입력받은데이터로 모두 변경

			Manager mng = (Manager)manager.getSession();
			mng.setName(name);
			mng.setOwnNo(ownNo);
			mng.setTel(tel);
			mng.setAddr(addr);
			mng.setType(type);
			mng.setPwd(pwd);			
			
			//서버로 객체 전달
			
			// 메인화면으로 이동
			moveToManagerMain(manager);
		}

		// 뒤로가기
		public void moveToManagerMain(Session manager) {
			
			
			
			
		
		}
}