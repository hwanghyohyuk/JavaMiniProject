package com.galgeyo.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

//아이디, 패스워드 찾기
public class FindInfoView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public FindInfoView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(41, 229, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(41, 260, 57, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(110, 223, 116, 29);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 265, 116, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_findInfo_1.png"));
		btnNewButton.setBounds(238, 215, 116, 79);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(41, 375, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(41, 406, 57, 15);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 373, 116, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 404, 116, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_findInfo_1.png"));
		btnNewButton_1.setBounds(238, 361, 116, 79);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("회원가입 시 입력한 정보로 아이디와 비밀번호를 검색합니다.");
		lblNewLabel_4.setBounds(51, 76, 338, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("비밀번호 찾기");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(87, 317, 89, 34);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("아이디 찾기");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(87, 171, 89, 34);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_findInfo_2.png"));
		lblNewLabel_7.setBounds(41, 317, 34, 34);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_findInfo_2.png"));
		lblNewLabel_8.setBounds(41, 171, 34, 34);
		add(lblNewLabel_8);
		
		JLabel lblIdpw = new JLabel("ID/PW 찾기");
		lblIdpw.setBounds(94, 38, 80, 23);
		add(lblIdpw);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_login_2.png"));
		lblNewLabel_9.setBounds(41, 22, 41, 44);
		add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.setBounds(394, 0, 80, 23);
		add(btnNewButton_2);
	}
}
