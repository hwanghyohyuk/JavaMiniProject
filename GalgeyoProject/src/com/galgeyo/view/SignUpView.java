package com.galgeyo.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//회원가입
public class SignUpView extends JFrame {
	public SignUpView() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lbl_regLogo = new JLabel("");
		lbl_regLogo.setIcon(new ImageIcon("gui_imgs/icon_signUp_1.png"));
		lbl_regLogo.setBackground(Color.WHITE);
		lbl_regLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_regLogo.setBounds(12, 43, 470, 229);
		getContentPane().add(lbl_regLogo);

		JButton btn_regUser = new JButton("");
		btn_regUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUpUserView();
				dispose();
			}
		});
		btn_regUser.setIcon(new ImageIcon("gui_imgs/btn_signUp_1.png"));
		btn_regUser.setBackground(Color.WHITE);
		btn_regUser.setBounds(80, 282, 330, 115);
		getContentPane().add(btn_regUser);

		JButton btn_regManager = new JButton("");
		btn_regManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUpManagerView();
				dispose();
			}
		});
		btn_regManager.setIcon(new ImageIcon("gui_imgs/btn_signUp_2.png"));
		btn_regManager.setBackground(Color.WHITE);
		btn_regManager.setBounds(80, 407, 330, 112);
		getContentPane().add(btn_regManager);

		JButton btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginView();
				dispose();
			}
		});
		btn_back.setBounds(383, 10, 100, 25);
		getContentPane().add(btn_back);

		this.setVisible(true);
	}

}
