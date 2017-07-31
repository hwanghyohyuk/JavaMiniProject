package com.galgeyo.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

//관리자 회원가입
public class SignUpManagerView  extends JPanel{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public SignUpManagerView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(116, 36, 112, 53);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_1.setBounds(60, 146, 57, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_2.setBounds(60, 191, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setBounds(60, 322, 57, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("업종");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_4.setBounds(60, 350, 69, 15);
		add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(141, 218, 116, 31);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 185, 116, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 317, 116, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 350, 116, 28);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_signUp_3.png"));
		btnNewButton.setBounds(272, 146, 81, 32);
		add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("회원님의 정보를 입력해주세요.");
		lblNewLabel_5.setBounds(60, 99, 168, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\icon_signUp_2.png"));
		lblNewLabel_6.setBounds(47, 36, 57, 53);
		add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("뒤로가기");
		btnNewButton_1.setBounds(369, 0, 81, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_signUp_4.png"));
		btnNewButton_2.setBounds(103, 397, 151, 65);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("매장이름");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_7.setBounds(60, 225, 57, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("사업자번호");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_8.setBounds(60, 258, 69, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("전화번호");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_9.setBounds(60, 291, 57, 15);
		add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 251, 116, 31);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(141, 286, 116, 28);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(141, 150, 116, 28);
		add(textField_6);
		textField_6.setColumns(10);
	}

}
