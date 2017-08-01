
package com.galgeyo.view;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


//관리자 메인화면
public class ManagerMainView extends JFrame implements ActionListener{
		
	private JTable table1;
	private JTable table2;
	
	private JButton btn_logout;
	private JButton btn_storeInfoEdit;
	private JButton btn_menuManagement;
	private JButton btn_totalOrder;
	private JButton btn_open_or_close;
	private JButton btn_accept;
	private JButton btn_acceptCancel;
	
	public ManagerMainView() {
		
		this.setSize(800, 600);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 57, 43));
		panel.setBounds(0, 0, 784, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title_text = new JLabel("마이페이지");
		title_text.setIcon(null);
		title_text.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		title_text.setBounds(86, 20, 302, 40);
		panel.add(title_text);
		
		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_user_1.png"));
		title_icon.setBounds(32, 16, 50, 50);
		panel.add(title_icon);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		logo.setBounds(666, 3, 99, 73);
		panel.add(logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(30, 90, 720, 143);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel imgLabel_preview = new JLabel("");
		imgLabel_preview.setBounds(10, 10, 132, 125);
		panel_1.add(imgLabel_preview);
		imgLabel_preview.setIcon(new ImageIcon("gui_imgs/thumbnail_img_sample.PNG"));
		
		JLabel label_strName = new JLabel("매장 이름");
		label_strName.setForeground(Color.DARK_GRAY);
		label_strName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		label_strName.setBounds(156, 17, 270, 29);
		panel_1.add(label_strName);
		
		JLabel label_mngName = new JLabel("관리자 아이디");
		label_mngName.setForeground(Color.DARK_GRAY);
		label_mngName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_mngName.setBounds(156, 52, 270, 23);
		panel_1.add(label_mngName);
		
		btn_open_or_close = new JButton();
		btn_open_or_close.setIcon(new ImageIcon("gui_imgs/btn_manager_1.png"));
		btn_open_or_close.setBounds(156, 89, 250, 45);
		panel_1.add(btn_open_or_close);
		
		btn_logout = new JButton();
		btn_logout.setIcon(new ImageIcon("gui_imgs/btn_logout.png"));
		btn_logout.setBounds(656, 2, 62, 22);
		btn_logout.setBorder(null);
		btn_logout.setBackground(null);
		panel_1.add(btn_logout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44, 62, 80));
		panel_2.setBounds(30, 243, 720, 60);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lavel_managementMenu = new JLabel("Management menu");
		lavel_managementMenu.setForeground(new Color(255, 255, 255));
		lavel_managementMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lavel_managementMenu.setBounds(16, 6, 228, 46);
		panel_2.add(lavel_managementMenu);
		
		btn_storeInfoEdit = new JButton();
				
		btn_storeInfoEdit.setBounds(224, 7, 170, 46);
		panel_2.add(btn_storeInfoEdit);
		btn_storeInfoEdit.setIcon(new ImageIcon("gui_imgs/btn_manager_2.png"));
		
		btn_menuManagement = new JButton("");
		btn_menuManagement.setIcon(new ImageIcon("gui_imgs/btn_manager_3.png"));
		btn_menuManagement.setBounds(400, 7, 130, 46);
		panel_2.add(btn_menuManagement);

		btn_totalOrder = new JButton("");
		btn_totalOrder.setIcon(new ImageIcon("gui_imgs/btn_manager_4.png"));
		btn_totalOrder.setBounds(536, 7, 170, 46);
		panel_2.add(btn_totalOrder);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 64, 64));
		panel_3.setBounds(30, 312, 356, 224);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_listTitle1 = new JLabel("응답 대기자 리스트");
		label_listTitle1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_listTitle1.setForeground(new Color(245, 245, 245));
		label_listTitle1.setBounds(12, 8, 144, 27);
		panel_3.add(label_listTitle1);
		
		table1 = new JTable();
		table1.setBounds(12, 41, 332, 132);
		panel_3.add(table1);
		
		btn_accept = new JButton("");
		btn_accept.setIcon(new ImageIcon("gui_imgs/btn_manager_5.png"));
		btn_accept.setBounds(138, 182, 82, 30);
		panel_3.add(btn_accept);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(394, 312, 356, 224);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("예약 주문자 리스트");
		label.setForeground(new Color(245, 245, 245));
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label.setBounds(12, 8, 144, 27);
		panel_4.add(label);
		
		table2 = new JTable();
		table2.setBounds(12, 41, 332, 132);
		panel_4.add(table2);
				
		btn_acceptCancel = new JButton("");
		btn_acceptCancel.setIcon(new ImageIcon("gui_imgs/btn_manager_6.png"));
		btn_acceptCancel.setBounds(138, 182, 82, 30);
		panel_4.add(btn_acceptCancel);
		
		//addActionListener
		btn_logout.addActionListener(this);
		btn_storeInfoEdit.addActionListener(this);
		btn_menuManagement.addActionListener(this);
		btn_totalOrder.addActionListener(this);
		
		/*
		btn_storeInfoEdit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
		});
		*/
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//로그아웃 버튼 이벤트
		if(e.getSource()==btn_logout){
			new LoginView();
			dispose();
		}
		//매장정보수정 버튼 이벤트
		if(e.getSource()==btn_storeInfoEdit){
			new StoreEditView();
		}
		//메뉴관리 버튼 이벤트
		if(e.getSource()==btn_menuManagement){
			new MenuManagementView();
		}
		//주문내역 관리 이벤트
		if(e.getSource()==btn_totalOrder){
			new TotalOrderView();
		}
		//매장 OPEN/CLOSE 버튼 이벤트
		if(e.getSource()==btn_open_or_close){
			
		}
		//주문 승낙 버튼 이벤트
		if(e.getSource()==btn_accept){
			
		}
		//승낙 취소 버튼 이벤트
		if(e.getSource()==btn_acceptCancel){
			
		}
	}

	public static void main(String[] args){
		new ManagerMainView();
	}
	
}
