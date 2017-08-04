package com.galgeyo.view;

import javax.swing.table.DefaultTableModel;

import com.galgeyo.controller.OrderMenuController;
import com.galgeyo.server.ClientController;
import com.galgeyo.server.Protocol;
import com.galgeyo.server.SessionController;
import com.galgeyo.server.TimeHandler;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Menu;
import com.galgeyo.vo.MenuList;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.StoreList;
import com.galgeyo.vo.User;

//메뉴주문
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Font;



public class OrderMenuView extends JFrame implements Protocol{
	
	private JLabel lbl_order, lbl_orderTotal;
	private JTextField tf_serch;
	private JTable storeList;
	private JTable menuList;
	private OrderMenuController oc = new OrderMenuController();
	private JButton btn_order,btn_serch,btn_back;
	private Session session = new Session();
	private int menuType=0;
	private int totalPrice = 0;
	
	private DefaultTableModel dtmStore = new DefaultTableModel(new Object[][] {}, new String[] {
				"매장 이름","주소","전화번호"
			}){  //셀 수정 못하게 하는 부분
		 public boolean isCellEditable(int row, int column){
			    return false;
		 }};
	private DefaultTableModel dtmMenu = new DefaultTableModel(new Object[][] {}, new String[] {
			"분류", "메뉴이름", "가격", "수량"	}){  //셀 수정 못하게 하는 부분
		 public boolean isCellEditable(int row, int column){
			    return false;
		 }};
	

	
	public OrderMenuView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				session.setSession(new SessionController().sessionLoad());
				menuType = new SessionController().menuSelectOpen();
				User user = (User) session.getSession();
				String menuTypeTemp = null;
				switch (menuType) {
				case 1:	
					menuTypeTemp="한식";
					break;
				case 2:					
					menuTypeTemp="중식";
					break;
				case 3:					
					menuTypeTemp="일식";
					break;
				case 4:					
					menuTypeTemp="분식";
					break;
				}
				lbl_order.setText(menuTypeTemp+ " 메뉴 주문");
				
				Object result= new ClientController().send(GET, STORE_LIST, menuTypeTemp);
				if (result instanceof StoreList) {
					StoreList storelist = (StoreList) result;
					ArrayList<Manager> store = storelist.getStoreList();
					Object[][] resultList = new Object[store.size()][9];
					for (int i = 0; i < resultList.length; i++) {
						//resultList[i][0] = ((Manager) (store.get(i))).isUser();
						//resultList[i][1] = ((Manager) (store.get(i))).getId();
						//resultList[i][2]=((Manager)(store.get(i))).getPwd();
						resultList[i][0] = ((Manager) (store.get(i))).getName();
						resultList[i][2]=((Manager)(store.get(i))).getTel();
						//resultList[i][5] = ((Manager) (store.get(i))).getOwnNo();
						resultList[i][1]=((Manager)(store.get(i))).getAddr();
						//resultList[i][7] = ((Manager) (store.get(i))).getType();
						//resultList[i][8]=((Manager)(store.get(i))).isOpen();
					}
					for (int i = 0; i < resultList.length; i++) {
						dtmStore.addRow(resultList[i]);
					}
				}
			}
		});
		this.setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192,57,43));
		panel.setBounds(0, 0, 794, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl_order = new JLabel("메뉴 주문");
		lbl_order.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lbl_order.setIcon(new ImageIcon("gui_imgs/ㅁㄴㅁㄴㅇㅁㄴㅇ.PNG"));
		lbl_order.setBounds(86, 10, 302, 60);
		panel.add(lbl_order);
		
		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_selectCategory_1.png"));
		title_icon.setBounds(12, 10, 62, 60);
		panel.add(title_icon);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lbl_logo.setBounds(666, 3, 99, 73);
		panel.add(lbl_logo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(12, 127, 379, 435);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_img3 = new JLabel("매장 검색");
		lbl_img3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		lbl_img3.setForeground(Color.WHITE);
		lbl_img3.setBackground(new Color(255, 255, 240));
		lbl_img3.setBounds(12, 10, 147, 32);
		panel_2.add(lbl_img3);
		
		tf_serch = new JTextField();
		tf_serch.setBounds(12, 52, 303, 38);
		panel_2.add(tf_serch);
		tf_serch.setColumns(10);
		
		btn_serch = new JButton("");
		btn_serch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel resultDtm = new DefaultTableModel(new Object[][] {},
						new String[] { "매장 이름","주소","전화번호" }){  //셀 수정 못하게 하는 부분
					 public boolean isCellEditable(int row, int column){
						    return false;
					 }};
				String searchStr = tf_serch.getText();
				if (!searchStr.equals("")) {
					for (int i = 0; i < dtmStore.getRowCount(); i++) {
						if (searchStr.equals((String) dtmStore.getValueAt(i, 1))) {// 문자열을
							resultDtm.addRow(new Object[] { dtmStore.getValueAt(i, 0), dtmStore.getValueAt(i, 1), dtmStore.getValueAt(i, 2), dtmStore.getValueAt(i, 3) });
						}
					}
					if (resultDtm.getRowCount() == 0) {
						resultDtm.addRow(new String[] { "검색", "결과가", "없습", "니다" });
					}
					menuList.setModel(resultDtm);
				} else {
					menuList.setModel(dtmStore);
				}
			}
		});
		
		btn_serch.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_1.png"));
		btn_serch.setBounds(327, 52, 40, 38);
		panel_2.add(btn_serch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 355, 325);
		panel_2.add(scrollPane);
		
		storeList = new JTable();
		storeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		storeList.setModel(dtmStore);
		storeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = storeList.getSelectedRow();
				String storeName = (String) storeList.getValueAt(row, 0);
				Object result = new ClientController().send(GET, STORE_MENU_LIST, storeName);
				if (result instanceof MenuList) {
					MenuList menulist = (MenuList) result;
					ArrayList<Menu> menu = menulist.getMenuList();
					Object[][] resultList = new Object[menu.size()][6];
					for (int i = 0; i < resultList.length; i++) {
						//resultList[i][0] = ((Menu) (menu.get(i))).getMenuNo();
						resultList[i][1] = ((Menu) (menu.get(i))).getMenuName();
						resultList[i][0]=((Menu)(menu.get(i))).getCategory();
						resultList[i][2] = ((Menu) (menu.get(i))).getPrice();
						//resultList[i][4]=((Menu)(menu.get(i))).getDiscount();
						//resultList[i][3] = ((Menu) (menu.get(i))).isOrderYN();
						resultList[i][3]=new Integer(0);
					}
					for (int i = 0; i < resultList.length; i++) {
						dtmMenu.addRow(resultList[i]);
					}
				}
			}
		});
		scrollPane.setViewportView(storeList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(403, 127, 379, 435);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_img = new JLabel("메뉴판");
		lbl_img.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		lbl_img.setForeground(Color.WHITE);
		lbl_img.setBackground(new Color(255, 255, 240));
		lbl_img.setBounds(12, 10, 121, 28);
		panel_1.add(lbl_img);
		
		btn_order = new JButton("");
		btn_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sendMessage="";
				int storeSelectedRow = storeList.getSelectedRow();
				String orderTime = new TimeHandler().getOrderTime();
				String bookingTime = (String) JOptionPane.showInputDialog(null,"몇 분 후에 오시나요?\n예약시간을 입력해주세요.\n현재 시간 : "+orderTime+"\n입력 예 : 10 (10분 후로 예약)", "예약시간 전송", JOptionPane.INFORMATION_MESSAGE);
				int bookingTimeInt = Integer.parseInt(bookingTime);
				if(bookingTime.equals("")){
					JOptionPane.showMessageDialog(null,"예약이 취소되었습니다","예약 취소",JOptionPane.INFORMATION_MESSAGE);
				}else if(Integer.parseInt(bookingTime)<60){
					String receipt = "주문하신 메뉴 리스트입니다.\n메뉴                   가격        주문수량   계산된 가격\n";
					for(int i=0;i<menuList.getRowCount();i++){
						String menuName = (String) menuList.getValueAt(i, 1);
						int menuPrice = (Integer) menuList.getValueAt(i,2);
						int quant = (Integer) menuList.getValueAt(i, 3);
						if(quant>0){
							if(i!=0){
								sendMessage+="/"+menuName+"_"+menuPrice+"_"+quant;						
							}else{
								sendMessage+=menuName+"_"+menuPrice+"_"+quant;	
							}
							receipt+=menuName+"      "+menuPrice+"                        "+quant+"            "+(menuPrice*quant)+"\n";
						}
					}
					receipt+="\n주문하신 메누 리스트의 총 가격은 "+totalPrice+" 원 입니다.\n";
					receipt+="예약시간 "+bookingTime+"분 후";
					User user = (User) session.getSession();
					
					String[] hm = orderTime.split(":");
					int hour = Integer.parseInt(hm[0]);
					int min = Integer.parseInt(hm[1]);
					if((min+=bookingTimeInt)>59){
						hour = (++hour)%24;
						min-=60;
					}
					String h="";
					if(hour<10){
						h="0"+(hour%10);
					}else{
						h=String.valueOf(hour);
					}
					String m="";
					if(min<10){
						m="0"+(min%10);
					}else{
						m=String.valueOf(min);
					}
					String reservation = h+":"+m;
					
					Order order = new Order((String)storeList.getValueAt(storeSelectedRow, 0),new TimeHandler().makeOrderNo(), user.getName(), user.getTel(), reservation, sendMessage);
					Object result = new ClientController().send(POST, ORDER_MENU, order);				
					if(result instanceof Boolean){
						boolean check = (Boolean)result;
						if(check){
							JOptionPane.showMessageDialog(null,receipt,"예약 완료",JOptionPane.INFORMATION_MESSAGE);
							new UserMainView();
							dispose();
						}else{
							JOptionPane.showMessageDialog(null,"예약이 완료되지 못했습니다.","예약 실패",JOptionPane.INFORMATION_MESSAGE);
						}
					}					
				}else{
					JOptionPane.showMessageDialog(null,"예약시간은 60분을 초과할 수 없습니다","예약 취소",JOptionPane.WARNING_MESSAGE);
				}				
			}
		});
		btn_order.setFont(new Font("굴림", Font.BOLD, 14));
		btn_order.setIcon(new ImageIcon("gui_imgs/btn_orderMenu_1.png"));
		btn_order.setBounds(217, 391, 150, 34);
		panel_1.add(btn_order);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 48, 355, 333);
		panel_1.add(scrollPane_1);
		
		menuList = new JTable();
		menuList.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				int row = menuList.getSelectedRow();
				if(row!=-1){
					int menuPrice = (Integer) menuList.getValueAt(row, 2);
					int menuQuantity = (Integer) menuList.getValueAt(row, 3);
					int step = -e.getWheelRotation();
					int quantity = menuQuantity+step;
					if(quantity>=0&&quantity<20){
						menuList.setValueAt(quantity, row, 3);
						if(menuQuantity<quantity){//수량증가
							totalPrice += menuPrice;
						}else{//수량감소
							totalPrice -= menuPrice;
						}
						if(totalPrice!=0){
							lbl_orderTotal.setText("최종가격 : "+totalPrice+" 원");
						}else{
							lbl_orderTotal.setText("");
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "메뉴를 선택하세요", "메뉴선택 오류", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.setModel(dtmMenu);
		scrollPane_1.setViewportView(menuList);
		
		lbl_orderTotal = new JLabel("");
		lbl_orderTotal.setForeground(Color.WHITE);
		lbl_orderTotal.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_orderTotal.setBounds(12, 391, 190, 34);
		panel_1.add(lbl_orderTotal);
		
		btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SelectMenuView();
				dispose();
			}
		});
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBounds(682, 90, 100, 28);
		getContentPane().add(btn_back);
		
		setVisible(true);
	}

}

