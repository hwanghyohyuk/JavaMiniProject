package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//로그인화면
public class LoginView extends JFrame {
	private JTextField tf_id;
	private JTextField tf_pwd;

	public LoginView() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lbl_logoImg = new JLabel("");
		lbl_logoImg.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_1.png"));
		lbl_logoImg.setBackground(Color.WHITE);
		lbl_logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logoImg.setBounds(12, 10, 470, 291);
		getContentPane().add(lbl_logoImg);

		tf_id = new JTextField();
		tf_id.setToolTipText("");
		tf_id.setBounds(121, 368, 163, 36);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);

		tf_pwd = new JTextField();
		tf_pwd.setBounds(121, 418, 163, 35);
		getContentPane().add(tf_pwd);
		tf_pwd.setColumns(10);

		JButton btn_login = new JButton("");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 로그인
				

			}
		});
		btn_login.setBackground(Color.WHITE);
		btn_login.setIcon(new ImageIcon("gui_imgs/btn_login_3.png"));
		btn_login.setBounds(296, 368, 100, 85);
		getContentPane().add(btn_login);

		JLabel lbl_idImg = new JLabel("");
		lbl_idImg.setIcon(new ImageIcon("gui_imgs/icon_login_1.png"));
		lbl_idImg.setBounds(90, 368, 34, 34);
		getContentPane().add(lbl_idImg);

		JLabel lbl_pwdImg = new JLabel("");
		lbl_pwdImg.setIcon(new ImageIcon("gui_imgs/icon_login_2.png"));
		lbl_pwdImg.setBounds(90, 418, 34, 36);
		getContentPane().add(lbl_pwdImg);

		JLabel lbl_regImg = new JLabel("");
		lbl_regImg.setIcon(new ImageIcon("gui_imgs/btn_login_1.png"));
		lbl_regImg.setBounds(121, 459, 41, 40);
		getContentPane().add(lbl_regImg);

		JLabel lbl_reg = new JLabel("회원가입");
		lbl_reg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUpView();
				dispose();
			}
		});
		lbl_reg.setBounds(162, 463, 69, 36);
		getContentPane().add(lbl_reg);

		JLabel lbl_findInfoImg = new JLabel("");
		lbl_findInfoImg.setIcon(new ImageIcon("gui_imgs/btn_login_2.png"));
		lbl_findInfoImg.setBounds(230, 463, 34, 36);
		getContentPane().add(lbl_findInfoImg);

		JLabel lblfindInfo = new JLabel("ID/PW 찾기");
		lblfindInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FindInfoView();
				dispose();
			}
		});
		lblfindInfo.setBounds(268, 463, 70, 36);
		getContentPane().add(lblfindInfo);

		setVisible(true);

	}
	public static void main(String[] args) {
		new LoginView();
	}
}
