package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;

//사용자 회원가입
public class SignUpUserView extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public SignUpUserView() {
		this.setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(129, 74, 82, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(73, 186, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(73, 221, 57, 32);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(73, 266, 57, 29);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("핸드폰번호");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(73, 305, 69, 31);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(154, 179, 192, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 266, 192, 29);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 308, 192, 28);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(154, 225, 192, 28);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("gui_imgs/btn_signUp_3.png"));
		btnNewButton.setBounds(358, 179, 82, 32);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("회원님의 정보를 입력해주세요.");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(73, 126, 168, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("gui_imgs/icon_signUp_2.png"));
		lblNewLabel_6.setBounds(60, 62, 57, 54);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("뒤로가기");
		btnNewButton_1.setBounds(382, 10, 100, 25);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("gui_imgs/btn_signUp_4.png"));
		btnNewButton_2.setBounds(175, 441, 150, 65);
		getContentPane().add(btnNewButton_2);
		
		this.setVisible(true);
	}

}
