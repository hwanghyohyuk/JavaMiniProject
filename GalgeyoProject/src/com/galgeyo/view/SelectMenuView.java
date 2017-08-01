package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//메뉴선택
public class SelectMenuView extends JFrame  implements ActionListener {
	
	public SelectMenuView() {
		getContentPane().setLayout(null);
		this.setBounds(0, 0, 800, 612);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 57, 43));
		panel.setBounds(0, 0, 800, 70);
		getContentPane().add(panel);
		panel.setLayout(null);


		JLabel lblNewLabel = new JLabel("메뉴 선택");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel.setBounds(116, 24, 149, 26);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\logo_galgeyo_2.png"));
		lblNewLabel_1.setBounds(695, 10, 93, 52);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\icon_selectCategory_1.png"));
		lblNewLabel_3.setBounds(37, 14, 52, 49);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 71, 800, 530);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("한식");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_selectCategory_1.png"));
		btnNewButton_1.setBounds(89, 30, 280, 226);
		btnNewButton_1.addActionListener(this);
		panel_1.add(btnNewButton_1);
		
		JButton button = new JButton("중식");
		button.addActionListener(this);
		button.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_selectCategory_2.png"));
		button.setBounds(455, 30, 273, 226);
		panel_1.add(button);
		
		JButton button_1 = new JButton("일식");
		button_1.addActionListener(this);
		button_1.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_selectCategory_3.png"));
		button_1.setBounds(89, 266, 273, 226);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("분식");
		button_2.addActionListener(this);
		button_2.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_selectCategory_5.png"));
		button_2.setBounds(455, 266, 273, 226);
		panel_1.add(button_2);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(677, -3, 97, 23);
		panel_1.add(btnNewButton);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("한식")) {
			new OrderMenuView();
			dispose();
		}
		else if (e.getActionCommand().equals("중식")) {
			new OrderMenuView();
			dispose();
		}
		else if (e.getActionCommand().equals("일식")) {
			new OrderMenuView();
			dispose();
		}
		else if (e.getActionCommand().equals("분식")) {
			new OrderMenuView();
			dispose();
		}
		else if(e.getActionCommand().equals("뒤로가기")) {
			new UserMainView();
			dispose();
		}
	}
}
