package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

//메뉴관리 화면
public class  MenuManagementView extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	public MenuManagementView() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		this.setSize(800, 600);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192,57,43));
		panel.setBounds(0, 0, 784, 75);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("메뉴관리");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(58, 10, 100, 55);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/icon_user_3.png"));
		lblNewLabel_4.setBounds(12, 10, 57, 55);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/logo_galgeyo_2.png"));
		lblNewLabel_5.setBounds(672, 10, 100, 55);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(396, 111, 376, 428);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("메뉴 추가");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		lblNewLabel.setBounds(12, 10, 121, 25);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("메뉴 번호");
		label.setForeground(Color.WHITE);
		label.setBounds(23, 45, 57, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("메뉴 이름");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(23, 80, 57, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("분류");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(23, 105, 57, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("가격");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(23, 135, 57, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("할인율");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(23, 175, 57, 15);
		panel_1.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("이미지 URL");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(23, 210, 88, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("주문가능여부");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(23, 288, 88, 15);
		panel_1.add(label_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("possible");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(new Color(42,66,80));
		rdbtnNewRadioButton.setBounds(119, 284, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("impossible");
		radioButton.setForeground(Color.WHITE);
		radioButton.setBounds(119, 309, 121, 23);
		radioButton.setBackground(new Color(42,66,80));

		panel_1.add(radioButton);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_menuEdit_3.png"));
		btnNewButton.setBounds(119, 360, 152, 34);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(119, 42, 116, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 77, 116, 21);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 102, 116, 21);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 132, 116, 21);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(119, 172, 116, 21);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(119, 207, 116, 21);
		panel_1.add(textField_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(12, 111, 372, 428);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("메뉴 검색 및 삭제");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 14));
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
		btnNewButton_1.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_menuEdit_1.png"));
		btnNewButton_1.setBounds(298, 52, 46, 38);
		panel_2.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 114, 322, 239);
		panel_2.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "\uBA54\uB274\uC774\uB984", "\uBD84\uB958", "\uAC00\uACA9", "y/n"
			}
		));
		scrollPane.setViewportView(table_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_menuEdit_2.png"));
		btnNewButton_2.setBounds(123, 363, 129, 34);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("뒤로가기");
		lblNewLabel_6.setForeground(new Color(42,66,80));
		lblNewLabel_6.setBounds(715, 85, 57, 15);
		getContentPane().add(lblNewLabel_6);
		
		setVisible(true);
	}

}
