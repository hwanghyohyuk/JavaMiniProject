package com.galgeyo.view;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Color;

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
		getContentPane().setLayout(null);
		this.setBounds(0,0,800,600);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 75);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("마이페이지");
		lblNewLabel_2.setBounds(12, 10, 100, 15);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(192, 192, 192));
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(396, 111, 376, 428);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("메뉴 추가");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		lblNewLabel.setBounds(12, 10, 57, 15);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("메뉴 번호");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(23, 45, 57, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("메뉴 이름");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setBounds(23, 80, 57, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("분류");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setBounds(23, 105, 57, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("가격");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setBounds(23, 135, 57, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("할인율");
		label_4.setForeground(Color.LIGHT_GRAY);
		label_4.setBounds(23, 175, 57, 15);
		panel_1.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("이미지 URL");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(23, 210, 88, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("주문가능여부");
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setBounds(23, 288, 88, 15);
		panel_1.add(label_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("possible");
		rdbtnNewRadioButton.setBackground(Color.GRAY);
		rdbtnNewRadioButton.setBounds(119, 284, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("impossible");
		radioButton.setBounds(119, 309, 121, 23);
		panel_1.add(radioButton);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(139, 365, 97, 23);
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
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setBounds(12, 10, 114, 15);
		panel_2.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(22, 35, 231, 21);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setBounds(265, 34, 97, 23);
		panel_2.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 350, 352);
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
	}
}