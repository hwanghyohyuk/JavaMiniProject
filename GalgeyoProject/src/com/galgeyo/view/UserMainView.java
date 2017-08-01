package com.galgeyo.view;

import javax.swing.JFrame;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 사용자 메인화면


public class UserMainView extends JFrame implements ActionListener {
	private JTable table;
	private JTable table_1;
	
	public UserMainView() {
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
		title_icon.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\111.PNG"));
		title_icon.setBounds(32, 16, 50, 50);
		panel.add(title_icon);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\logo_galgeyo_2.png"));
		logo.setBounds(666, 3, 99, 73);
		panel.add(logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 90, 762, 154);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel imgLabel_preview = new JLabel("");
		imgLabel_preview.setBounds(10, 10, 132, 125);
		panel_1.add(imgLabel_preview);
		imgLabel_preview.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\thumbnail_img_sample.PNG"));
		
		JLabel label_strName = new JLabel("사용자 이름");
		label_strName.setForeground(Color.DARK_GRAY);
		label_strName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		label_strName.setBounds(156, 17, 270, 29);
		panel_1.add(label_strName);
		
		JLabel label_mngName = new JLabel("사용자 아이디");
		label_mngName.setForeground(Color.DARK_GRAY);
		label_mngName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_mngName.setBounds(156, 52, 270, 23);
		panel_1.add(label_mngName);
		
		JEditorPane textLink_logout = new JEditorPane();
		textLink_logout.setBounds(656, 0, 64, 30);
		panel_1.add(textLink_logout);
		textLink_logout.setEditable(false);
		textLink_logout.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		textLink_logout.setForeground(new Color(52, 73, 94));
		textLink_logout.setText("로그아웃");
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(44, 62, 80));
		panel_2.setBounds(0, 254, 772, 60);
		getContentPane().add(panel_2);
		
		JLabel lblUserMenu = new JLabel("User menu");
		lblUserMenu.setForeground(Color.WHITE);
		lblUserMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblUserMenu.setBounds(16, 6, 228, 46);
		panel_2.add(lblUserMenu);
		
		JButton btn_booking = new JButton("수정");
		btn_booking.addActionListener(this);
		btn_booking.setBounds(239, 6, 132, 46);
		panel_2.add(btn_booking);
		btn_booking.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_user_1.png"));
		
		//주문하기 버튼 누르면 메뉴선택 화면으로 이동
		JButton btnNewButton = new JButton("주문하러가기");
		btnNewButton.setBounds(389, 15, 113, 37);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(12, 323, 356, 224);
		getContentPane().add(panel_3);
		
		JLabel label_1 = new JLabel("즐겨찾기");
		label_1.setForeground(new Color(245, 245, 245));
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_1.setBounds(12, 8, 144, 27);
		panel_3.add(label_1);
		
		table = new JTable();
		table.setBounds(12, 41, 332, 173);
		panel_3.add(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(416, 323, 356, 224);
		getContentPane().add(panel_4);
		
		JLabel label_2 = new JLabel("최근 주문 내역");
		label_2.setForeground(new Color(245, 245, 245));
		label_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_2.setBounds(12, 8, 144, 27);
		panel_4.add(label_2);
		
		table_1 = new JTable();
		table_1.setBounds(12, 41, 332, 173);
		panel_4.add(table_1);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new UserMainView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("주문하러가기")) {
			new SelectMenuView();
		}
		else if (e.getActionCommand().equals("수정")) {
			new UserInfoEditView();
		}
	}
}
