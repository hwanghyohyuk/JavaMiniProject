package com.galgeyo.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

//로그인화면
public class LoginView extends JFrame{
	private JTextField txtGalgeyo;
	private JTextField tf_id;
	private JTextField tf_pwd;
	public LoginView() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setBounds(144, 297, 69, 36);
		getContentPane().add(lblNewLabel);
		
		tf_id = new JTextField();
		tf_id.setText("사용자 아이디");
		tf_id.setBounds(103, 202, 163, 36);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		tf_pwd = new JTextField();
		tf_pwd.setText("비밀번호");
		tf_pwd.setBounds(103, 252, 163, 35);
		getContentPane().add(tf_pwd);
		tf_pwd.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_login_3.png"));
		btnNewButton.setBounds(278, 202, 100, 85);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID/PW 찾기");
		lblNewLabel_1.setBounds(250, 297, 70, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\logo_galgeyo_1.png"));
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(72, 31, 306, 161);
		getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_login_1.png"));
		lblNewLabel_2.setBounds(72, 202, 34, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_login_2.png"));
		lblNewLabel_3.setBounds(72, 252, 34, 36);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_login_1.png"));
		lblNewLabel_4.setBounds(103, 293, 41, 40);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_login_2.png"));
		lblNewLabel_5.setBounds(212, 297, 34, 36);
		getContentPane().add(lblNewLabel_5);
		
		
	}
}
