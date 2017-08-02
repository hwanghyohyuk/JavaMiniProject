package com.galgeyo.view;

import javax.swing.*;

import com.galgeyo.controller.SessionController;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;

import java.awt.*;
import java.awt.event.*;

//매장정보 수정
public class StoreEditView extends JFrame implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;
	private JButton btnNewButton;
	
	private Session session = new Session();
	private JTextField textField_5;

	public StoreEditView() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				session.setSession(new SessionController().sessionLoad());
				Manager manager = (Manager) session.getSession();
			}
		});

		this.setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 57, 43));
		panel.setBounds(0, 0, 794, 80);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("매장 정보 수정");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(86, 10, 228, 60);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_6.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/icon_storeInfoEdit_1.png"));
		lblNewLabel_6.setBounds(12, 10, 62, 60);
		panel.add(lblNewLabel_6);

		JLabel label = new JLabel("");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/logo_galgeyo_2.png"));
		label.setBounds(686, 10, 102, 47);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 90, 794, 482);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("매장 이름");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1.setBounds(74, 82, 81, 29);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("사업자번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2.setBounds(74, 134, 81, 28);
		panel_1.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField.setBounds(187, 245, 350, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_1.setBounds(186, 83, 198, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/btn_menuEdit_3.png"));
		btnNewButton_1.setBounds(637, 421, 145, 51);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_3.setBounds(74, 194, 80, 28);
		panel_1.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_3.setBounds(186, 135, 198, 28);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("수정할 정보를 입력해주세요.");
		lblNewLabel_4.setForeground(new Color(42, 66, 80));
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_4.setBounds(106, 28, 278, 29);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("주소");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_5.setBounds(74, 245, 81, 28);
		panel_1.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_4.setBounds(186, 194, 198, 28);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		btnNewButton = new JButton("뒤로가기");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(682, 0, 100, 28);
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_7.setBounds(50, 10, 49, 47);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon("GalgeyoProject/gui_imgs/icon_storeInfoEdit_2.png"));

		JLabel lblNewLabel_8 = new JLabel("업종");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_8.setBounds(74, 298, 57, 29);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("비밀번호");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_9.setBounds(74, 361, 57, 15);
		panel_1.add(lblNewLabel_9);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"업종을 선택하세요.", "한식", "중식", "일식", "분식"}));
		comboBox.setBounds(187, 296, 145, 34);
		panel_1.add(comboBox);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(186, 355, 198, 28);
		panel_1.add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(187, 401, 198, 28);
		panel_1.add(textField_5);
		
		JLabel label_1 = new JLabel("비밀번호");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setBounds(74, 408, 57, 15);
		panel_1.add(label_1);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			new ManagerMainView();
			dispose();
		}
	}
}
