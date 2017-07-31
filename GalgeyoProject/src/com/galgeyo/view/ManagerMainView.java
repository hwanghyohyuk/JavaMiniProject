package com.galgeyo.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//관리자 메인화면
public class ManagerMainView extends JFrame {
	
	private JTable table1;
	private JTable table2;
	
	public ManagerMainView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(200, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		title_icon.setIcon(new ImageIcon("C:/Users/user1/Documents/GitHub/JavaMiniProject/GalgeyoProject/gui_imgs/icon_user_1.png"));
		title_icon.setBounds(32, 16, 50, 50);
		panel.add(title_icon);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:/Users/user1/Documents/GitHub/JavaMiniProject/GalgeyoProject/gui_imgs/logo_galgeyo_2.png"));
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
		imgLabel_preview.setIcon(new ImageIcon("C:/Users/user1/Documents/GitHub/JavaMiniProject/GalgeyoProject/gui_imgs/thumbnail_img_sample.PNG"));
		
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
		
		JButton btn_booking = new JButton("");
		btn_booking.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_manager_1.png"));
		btn_booking.setBounds(156, 89, 250, 45);
		panel_1.add(btn_booking);
		
		JEditorPane textLink_logout = new JEditorPane();
		textLink_logout.setBounds(656, 0, 64, 30);
		panel_1.add(textLink_logout);
		textLink_logout.setEditable(false);
		textLink_logout.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		textLink_logout.setForeground(new Color(52, 73, 94));
		textLink_logout.setText("로그아웃");
		
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
		
		JButton btn_storeInfoEdit = new JButton("");
		btn_storeInfoEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_storeInfoEdit.setBounds(224, 7, 170, 46);
		panel_2.add(btn_storeInfoEdit);
		btn_storeInfoEdit.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_manager_2.png"));
		
		JButton btn_menuManagement = new JButton("");
		btn_menuManagement.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_manager_3.png"));
		btn_menuManagement.setBounds(400, 7, 130, 46);
		panel_2.add(btn_menuManagement);
		
		JButton btn_totalOrder = new JButton("");
		btn_totalOrder.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_manager_4.png"));
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
		
		JButton btn_apply1 = new JButton("");
		btn_apply1.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_manager_5.png"));
		btn_apply1.setBounds(138, 182, 82, 30);
		panel_3.add(btn_apply1);
		
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
		
		JButton btn_apply2 = new JButton("");
		btn_apply2.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_manager_6.png"));
		btn_apply2.setBounds(138, 182, 82, 30);
		panel_4.add(btn_apply2);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new ManagerMainView();
	}
}
