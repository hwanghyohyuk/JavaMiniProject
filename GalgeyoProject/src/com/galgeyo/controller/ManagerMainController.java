package com.galgeyo.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Menu;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.Session;

//매장 관리자의 메인 화면에 대한 메소드 구현

public class ManagerMainController {

	// 예약 가능 / 불가능 (switch button)
	public boolean switchReservation(Session manager) {
		System.out.println(manager.toString());
		if (((Manager) manager.getSession()).isOpen()) {
			System.out.println("false");
			((Manager) manager.getSession()).setOpen(false);
			//세션을 서버로 보냄
			return false;
		} else {
			((Manager) manager.getSession()).setOpen(true);
			//세션을 서버로 보냄
			return true;
		}
	}

	public void waitsave() {
		Properties prop = new Properties();
		HashMap<Menu, Integer> orderMenu = new HashMap<>();
		Menu menu = new Menu("a1", "짜장면", "main", 5000, 0.1, "imgUrl", true);
		orderMenu.put(menu, 4);
		String sb = "";
		Iterator<Entry<Menu, Integer>> iter = orderMenu.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Menu, Integer> entry = iter.next();
			Menu m = entry.getKey();
			int q = entry.getValue();
			sb+=m.toString()+":"+q+",";
		}			
		String total = sb.substring(0,sb.length()-2);
		Order order = new Order(1, "h", "1", "11:22", sb);
		prop.setProperty(String.valueOf(order.getOrderNo()), order.toString());
		try {
			prop.store(new FileOutputStream("TestOrderProp.properties"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitload() {
		Properties prop = new  Properties();
		try {
			prop.load(new FileInputStream("TestOrderProp.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set set = prop.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = prop.getProperty(key);
			String s[] = value.split("/");
			String o[]= s[4].split(",");
			
		}
		
	}
	
	//응답 대기자 리스트
<<<<<<< HEAD
	public void waitUserList(HashMap<String, Order> waitUsers, DefaultTableModel dtm){
=======
	public DefaultTableModel waitUserList(/*HashMap<String, Order> waitUsers, */DefaultTableModel dtm){
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("TestOrderProp.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//String[] columnNames = {"No","이름","전화번호","예약시간","자세히","V"};
		
		Set<Object> kset = prop.keySet();
		Iterator<Object> iter = kset.iterator();
		StringBuilder sb = new StringBuilder();
		
		int i=0;
		
		while(iter.hasNext()) {
			String key = (String)iter.next();
			String value = prop.getProperty(key);
			
			String[] values = value.split("/");
			String[] menus = values[4].split(",");
			
			String[] values2 = {values[0], values[1], values[2], values[3]};
			dtm.addRow(values2);
						
			for(int k=0; k<menus.length; k++){
				String quan = String.valueOf(menus[i].charAt(0));
				String name = menus[i].substring(1, menus[i].length());
				sb.append(name+" "+quan+"개\n");
			}
			
			//자세히 눌렀을 때
			JOptionPane.showMessageDialog(new JButton("확인"),
					values[1]+"님의 주문내역\n"+sb);
				
			Order orderData = new Order(Integer.parseInt(values[0]), values[1], values[2], values[3], new String(sb));

			/*waitUsers.put(key, orderData);*/
		}
		
		return dtm;
>>>>>>> a919f37adf48453acc7684fa6e25cb9638147c47
		
	}
	//예약 주문자 리스트
	public void reserUserList(HashMap<String, Order> reserUsers, DefaultTableModel dtm){}
	//응답 대기자 리스트 → 예약 주문자 리스트
	public void updateAcceptUserList(int row, DefaultTableModel src_dtm,DefaultTableModel des_dtm){}
	//예약 주문자 리스트 아이템삭제
	public void updateReserUserList(int row, DefaultTableModel dtm){}

}
