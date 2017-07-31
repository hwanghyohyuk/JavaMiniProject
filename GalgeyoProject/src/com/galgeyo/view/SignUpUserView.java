package com.galgeyo.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

//사용자 회원가입
public class SignUpUserView extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public SignUpUserView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(116, 47, 82, 42);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(60, 159, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(60, 194, 57, 32);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(60, 239, 57, 29);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("핸드폰번호");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(60, 278, 69, 31);
		add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(141, 152, 116, 32);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 239, 116, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 281, 116, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 198, 116, 28);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_signUp_3.png"));
		btnNewButton.setBounds(261, 153, 82, 32);
		add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("회원님의 정보를 입력해주세요.");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(60, 99, 168, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\icon_signUp_2.png"));
		lblNewLabel_6.setBounds(47, 35, 57, 54);
		add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("뒤로가기");
		btnNewButton_1.setBounds(353, 0, 97, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_signUp_4.png"));
		btnNewButton_2.setBounds(116, 333, 149, 65);
		add(btnNewButton_2);
	}

}
