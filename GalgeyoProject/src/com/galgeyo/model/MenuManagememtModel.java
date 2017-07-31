package com.galgeyo.model;

import java.util.HashMap;

import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Menu;
import com.galgeyo.vo.Session;

public class MenuManagememtModel implements Protocol{

  //매장의 메뉴 데이터 받아오기
  public HashMap<String, Menu> getMenu(Session manager){
	  HashMap<String, Menu> menuList =null;
	  return menuList;
  }
  
  
  //체크한 메뉴 삭제 후 업데이트
  public void updateMenuDelete(HashMap<String, Menu> selectMenu){}
  
  //입력한 정보로 메뉴를 추가하고 업데이트
  public void updateMenuInsert(HashMap<String, Menu> syncMenu){}

}
