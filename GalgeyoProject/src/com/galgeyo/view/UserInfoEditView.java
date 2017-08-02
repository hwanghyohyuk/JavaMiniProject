package com.galgeyo.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 개인정보수정
public class UserInfoEditView extends JFrame implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	public UserInfoEditView() {

		setLayout(null);

		this.setBounds(0, 0, 800, 600);

		JPanel panel = new JPanel();

		panel.setBackground(new Color(192, 57, 43));

		panel.setBounds(0, 0, 800, 70);

		add(panel);

		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("개인정보수정");

		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 23));

		lblNewLabel.setBounds(93, 10, 228, 47);

		panel.add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("");

		lblNewLabel_6.setIcon(new ImageIcon("gui_imgs/icon_userInfoEdit_1.png"));

		lblNewLabel_6.setBounds(25, 7, 46, 50);

		panel.add(lblNewLabel_6);

		JPanel panel_1 = new JPanel();

		panel_1.setBackground(Color.WHITE);

		panel_1.setBounds(0, 70, 800, 530);

		add(panel_1);

		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("이름");

		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));

		lblNewLabel_1.setBounds(81, 195, 81, 29);

		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("전화번호");

		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));

		lblNewLabel_2.setBounds(81, 266, 81, 29);

		panel_1.add(lblNewLabel_2);

		textField = new JTextField();

		textField.setFont(new Font("굴림", Font.PLAIN, 14));

		textField.setBounds(193, 400, 116, 26);

		panel_1.add(textField);

		textField.setColumns(10);

		textField_1 = new JTextField();

		textField_1.setFont(new Font("굴림", Font.PLAIN, 14));

		textField_1.setBounds(193, 197, 116, 25);

		panel_1.add(textField_1);

		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("");

		btnNewButton_1.setIcon(new ImageIcon("gui_imgs/btn_storeInfoEdit_1.png"));

		btnNewButton_1.setBounds(633, 431, 107, 51);

		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("수정할 비밀번호");

		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 14));

		lblNewLabel_3.setBounds(81, 340, 80, 29);

		panel_1.add(lblNewLabel_3);

		textField_3 = new JTextField();

		textField_3.setBounds(193, 269, 116, 26);

		panel_1.add(textField_3);

		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("수정할 정보를 입력해주세요.");

		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 16));

		lblNewLabel_4.setBounds(145, 51, 278, 63);

		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("비밀번호 확인");

		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 14));

		lblNewLabel_5.setBounds(81, 391, 81, 42);

		panel_1.add(lblNewLabel_5);

		textField_4 = new JTextField();

		textField_4.setBounds(193, 344, 116, 24);

		panel_1.add(textField_4);

		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(677, 10, 97, 23);
		panel_1.add(btnNewButton);

		btnNewButton.setBackground(Color.WHITE);

		btnNewButton.setBounds(681, 10, 107, 29);

		panel_1.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("New label");

		lblNewLabel_7.setBounds(65, 60, 49, 47);

		panel_1.add(lblNewLabel_7);

		lblNewLabel_7.setIcon(new ImageIcon("Desktop/gui_imgs/icon_storeInfoEdit_2.png"));

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("뒤로가기")) {
			new UserMainView();
			dispose();
		}

	}
}
