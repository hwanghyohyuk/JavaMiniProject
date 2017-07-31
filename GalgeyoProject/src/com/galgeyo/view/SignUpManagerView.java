package com.galgeyo.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

//관리자 회원가입
public class SignUpManagerView  extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public SignUpManagerView() {
		this.setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("gui_imgs/icon_signUp_2.png"));
		lblNewLabel.setBounds(50, 62, 57, 53);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("회원가입");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(119, 62, 112, 53);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("회원님의 정보를 입력해주세요.");
		lblNewLabel_2.setBounds(85, 125, 200, 30);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setBounds(50, 179, 100, 28);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("비밀번호");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_4.setBounds(50, 219, 100, 28);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("주소");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_5.setBounds(50, 259, 100, 28);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("업종");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_6.setBounds(50, 299, 100, 28);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("매장이름");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_7.setBounds(50, 339, 100, 28);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("사업자번호");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_8.setBounds(50, 379, 100, 28);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("전화번호");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_9.setBounds(50, 419, 100, 28);
		getContentPane().add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(160, 179, 206, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 219, 206, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 259, 206, 28);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 299, 206, 28);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 339, 207, 28);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(160, 379, 207, 28);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(160, 419, 207, 28);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("gui_imgs/btn_signUp_3.png"));
		btnNewButton.setBounds(378, 179, 80, 28);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("뒤로가기");
		btnNewButton_1.setBounds(382, 10, 100, 25);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("gui_imgs/btn_signUp_4.png"));
		btnNewButton_2.setBounds(174, 476, 151, 65);
		getContentPane().add(btnNewButton_2);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SignUpManagerView();
	}

}
