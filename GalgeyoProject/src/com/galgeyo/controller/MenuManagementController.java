package com.galgeyo.controller;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import com.galgeyo.vo.Menu;

public class MenuManagementController {
	// 메뉴 리스트
	public void menuMagementList(HashMap<String, Menu> store, DefaultTableModel dtm) {
	}

	// 메뉴 초기 리스트
	public DefaultTableModel viewMenuList(DefaultTableModel dtm) {
		DefaultTableModel clone = dtm;
		return clone;
	}

	// 메뉴 검색
	public DefaultTableModel searchMenu(String storeName, DefaultTableModel dtm) {
		DefaultTableModel resultDtm = null;

		return resultDtm;
	}

	// 메뉴 삭제
	public void deleteMenu(int row, DefaultTableModel dtm) {

	}
	// 메뉴 추가
	public void addMenu(int menuNo, String menuName, String category, int price, double discount, String imgURL,boolean orderYN, DefaultTableModel dtm) {
		
	}
	// 메뉴 리스트에서 아이템이 클릭되어있으면 추가를 수정으로 간주함 
	public void modifyMenu(int row,int menuNo, String menuName, String category, int price, double discount, String imgURL,boolean orderYN, DefaultTableModel dtm) {
				
	}
}
