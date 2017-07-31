package com.galgeyo.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

//회원가입
public class SignUpView extends JPanel{
	public SignUpView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_signUp_1.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(80, 242, 330, 115);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\gui_imgs\\btn_signUp_2.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(80, 367, 330, 115);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_signUp_1.png"));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 35, 330, 197);
		add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.setBounds(438, 0, 81, 23);
		add(btnNewButton_2);
	}

}
