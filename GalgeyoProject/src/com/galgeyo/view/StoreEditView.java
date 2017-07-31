package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//매장정보 수정
public class StoreEditView extends JFrame implements ActionListener{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	private JButton btnNewButton;
	
	public StoreEditView() {
		setLayout(null);
			this.setSize(800, 600);
			setLocationRelativeTo(null);
			this.setResizable(false);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(192, 57, 43));
			panel.setBounds(0, 0, 800, 70);
			add(panel);
			panel.setLayout(null);
	
			JLabel lblNewLabel = new JLabel("매장 정보 수정");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblNewLabel.setBounds(70, 13, 228, 47);
		panel.add(lblNewLabel);
			
			JLabel lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/icon_storeInfoEdit_1.png"));
			lblNewLabel_6.setBounds(12, 10, 46, 50);
			panel.add(lblNewLabel_6);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/logo_galgeyo_2.png"));
			label.setBounds(686, 10, 102, 47);
			panel.add(label);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(0, 70, 800, 530);
			add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("매장 이름");
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_1.setBounds(81, 131, 81, 29);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("사업자번호");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_2.setBounds(81, 182, 81, 29);
			panel_1.add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setFont(new Font("굴림", Font.PLAIN, 14));
			textField.setBounds(194, 295, 287, 26);
			panel_1.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("굴림", Font.PLAIN, 14));
			textField_1.setBounds(193, 133, 116, 25);
		panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_menuEdit_3.png"));
			btnNewButton_1.setBounds(622, 452, 145, 51);
			panel_1.add(btnNewButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("전화번호");
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_3.setBounds(81, 240, 80, 29);
		panel_1.add(lblNewLabel_3);
	
			textField_3 = new JTextField();
			textField_3.setBounds(193, 185, 165, 26);
	panel_1.add(textField_3);
			textField_3.setColumns(10);
			
		JLabel lblNewLabel_4 = new JLabel("수정할 정보를 입력해주세요.");
		lblNewLabel_4.setForeground(new Color(42,66,80));
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			lblNewLabel_4.setBounds(121, 78, 278, 29);
			panel_1.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("주소");
			lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_5.setBounds(81, 286, 81, 42);
			panel_1.add(lblNewLabel_5);
			
			textField_4 = new JTextField();
			textField_4.setBounds(193, 244, 151, 24);
		panel_1.add(textField_4);
			textField_4.setColumns(10);
			
			btnNewButton = new JButton("뒤로가기");
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setBounds(681, 10, 107, 29);
			btnNewButton.addActionListener(this);
			panel_1.add(btnNewButton);
		
			JLabel lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setBounds(65, 60, 49, 47);
			panel_1.add(lblNewLabel_7);
			lblNewLabel_7.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/icon_storeInfoEdit_2.png"));
			
			JLabel lblNewLabel_8 = new JLabel("업종");
			lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_8.setBounds(81, 348, 57, 29);
			panel_1.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("비밀번호");
			lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_9.setBounds(81, 455, 57, 15);
			panel_1.add(lblNewLabel_9);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setForeground(Color.BLACK);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"업종을 선택하세요.", "한식", "중식", "일식", "분식"}));
			comboBox.setBounds(194, 346, 150, 34);
			panel_1.add(comboBox);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(194, 452, 151, 24);
			panel_1.add(textField_2);
			
		this.setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton){
				new ManagerMainView();
				dispose();
			}
		}
		
		public static void main(String[] args){
			new StoreEditView();
			}
		
}