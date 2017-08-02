package com.galgeyo.view;

import javax.swing.JPanel;

//메뉴주문


import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


//개인정보수정
public class OrderMenuView extends JFrame implements ActionListener{
	private JTextField textField_6;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	public OrderMenuView() {
		setVisible(true);
		getContentPane().setLayout(null);
		this.setBounds(0,0,800,600);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192,57,43));
		panel.setBounds(0, 0, 784, 75);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\ㅁㄴㅁㄴㅇㅁㄴㅇ.PNG"));
		lblNewLabel_4.setBounds(12, 10, 224, 55);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\logo_galgeyo_2.png"));
		lblNewLabel_5.setBounds(672, 10, 100, 55);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(396, 111, 376, 428);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("메뉴판");
		
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		lblNewLabel.setBounds(12, 22, 121, 25);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("주문하기");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_orderMenu_1.png"));
		btnNewButton.setBounds(214, 384, 150, 34);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 57, 342, 317);
		panel_1.add(scrollPane_1);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uBD84\uB958", "\uBA54\uB274\uC774\uB984"
			}
		));
		scrollPane_1.setViewportView(table_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(12, 111, 372, 428);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("매장 검색");
		
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setBounds(12, 10, 147, 32);
		panel_2.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(22, 52, 264, 38);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\user1\\Desktop\\식사하러가시죠\\gui_imgs\\btn_menuEdit_1.png"));
		btnNewButton_1.setBounds(298, 52, 46, 38);
		panel_2.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 114, 322, 280);
		panel_2.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uB9E4\uC7A5\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC990\uACA8\uCC3E\uAE30"
			}
		));
		scrollPane.setViewportView(table_2);
		
		JButton btnNewButton_2 = new JButton("뒤로가기");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(675, 78, 97, 23);
		getContentPane().add(btnNewButton_2);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("뒤로가기")) {
			new SelectMenuView();
			dispose();
		}
	}
}

