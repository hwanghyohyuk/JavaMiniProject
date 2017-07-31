package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//로그인화면
public class LoginView extends JFrame{
	private JTextField txtGalgeyo;
	private JTextField tf_id;
	private JTextField tf_pwd;
	public LoginView() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setBounds(162, 463, 69, 36);
		getContentPane().add(lblNewLabel);
		
		tf_id = new JTextField();
		tf_id.setToolTipText("");
		tf_id.setBounds(121, 368, 163, 36);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		tf_pwd = new JTextField();
		tf_pwd.setBounds(121, 418, 163, 35);
		getContentPane().add(tf_pwd);
		tf_pwd.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//로그인
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("gui_imgs/btn_login_3.png"));
		btnNewButton.setBounds(296, 368, 100, 85);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID/PW 찾기");
		lblNewLabel_1.setBounds(268, 463, 70, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_1.png"));
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 10, 470, 291);
		getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("gui_imgs/icon_login_1.png"));
		lblNewLabel_2.setBounds(90, 368, 34, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("gui_imgs/icon_login_2.png"));
		lblNewLabel_3.setBounds(90, 418, 34, 36);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("gui_imgs/btn_login_1.png"));
		lblNewLabel_4.setBounds(121, 459, 41, 40);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("gui_imgs/btn_login_2.png"));
		lblNewLabel_5.setBounds(230, 463, 34, 36);
		getContentPane().add(lblNewLabel_5);
		
		setVisible(true);
		
	}
}
