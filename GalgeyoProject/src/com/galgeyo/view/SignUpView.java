package com.galgeyo.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//회원가입
public class SignUpView extends JFrame{
	public SignUpView() {
		this.setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("gui_imgs/btn_signUp_1.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(80, 282, 330, 115);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("gui_imgs/btn_signUp_2.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(80, 407, 330, 115);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("gui_imgs/icon_signUp_1.png"));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 43, 470, 229);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.setBounds(383, 10, 100, 25);
		getContentPane().add(btnNewButton_2);
		
		this.setVisible(true);
	}

}
