package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import com.galgeyo.controller.SessionController;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;

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
	private Session session = new Session();
	
	public MenuManagementView() {

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
		panel.setBackground(new Color(192,57,43));
		panel.setBounds(0, 0, 794, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("메뉴관리");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel_2.setBounds(86, 10, 302, 60);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_4.setIcon(new ImageIcon("gui_imgs/icon_user_3.png"));
		lblNewLabel_4.setBounds(12, 10, 62, 60);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_5.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lblNewLabel_5.setBounds(666, 3, 99, 73);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(403, 128, 379, 434);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("메뉴 추가");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		lblNewLabel.setBounds(12, 10, 121, 25);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("메뉴 번호");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setForeground(Color.WHITE);
		label.setBounds(38, 84, 57, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("메뉴 이름");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(38, 115, 57, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("분류");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(38, 146, 57, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("가격");
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(38, 177, 57, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("할인율");
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(38, 208, 57, 15);
		panel_1.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("이미지 URL");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(38, 239, 88, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("주문가능여부");
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(38, 264, 88, 47);
		panel_1.add(label_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("possible");
		rdbtnNewRadioButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(new Color(42,66,80));
		rdbtnNewRadioButton.setBounds(135, 263, 121, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("impossible");
		radioButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		radioButton.setForeground(Color.WHITE);
		radioButton.setBounds(135, 288, 121, 23);
		radioButton.setBackground(new Color(42,66,80));

		panel_1.add(radioButton);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_3.png"));
		btnNewButton.setBounds(119, 390, 152, 34);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField.setBounds(135, 81, 190, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(135, 112, 190, 21);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(135, 143, 190, 21);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(135, 174, 190, 21);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(135, 205, 190, 21);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(135, 236, 190, 21);
		panel_1.add(textField_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(12, 128, 379, 434);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("메뉴 검색 및 삭제");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setBounds(12, 10, 147, 32);
		panel_2.add(lblNewLabel_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textField_6.setBounds(12, 52, 297, 38);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		
		btnNewButton_1.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_1.png"));
		btnNewButton_1.setBounds(321, 52, 46, 38);
		panel_2.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 355, 280);
		panel_2.add(scrollPane);
		
		table_2 = new JTable();
		table_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "\uBA54\uB274\uC774\uB984", "\uBD84\uB958", "\uAC00\uACA9", "y/n"
			}
		));
		scrollPane.setViewportView(table_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton_2.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_2.png"));
		btnNewButton_2.setBounds(122, 390, 129, 34);
		panel_2.add(btnNewButton_2);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ManagerMainView();
				dispose();
			}
		});
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(682, 90, 100, 28);
		getContentPane().add(btn_back);
		
		setVisible(true);
	}
	
}
