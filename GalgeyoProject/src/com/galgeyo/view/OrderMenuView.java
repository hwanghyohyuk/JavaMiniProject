package com.galgeyo.view;

import javax.swing.table.DefaultTableModel;

import com.galgeyo.controller.OrderMenuController;
import com.galgeyo.controller.SessionController;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.User;

//메뉴주문
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;



public class OrderMenuView extends JFrame {
	
	private JLabel lbl_order;
	private JTextField tf_serch;
	private JTable storeList;
	private JTable menuList;
	private OrderMenuController oc = new OrderMenuController();
	private JButton btn_order,btn_serch,btn_back;
	private Session session = new Session();
	private int menuType=0;
	
	private DefaultTableModel dtmStore = new DefaultTableModel(new Object[][] {}, new String[] {
				"\uB9E4\uC7A5\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC990\uACA8\uCC3E\uAE30"
			});
	
	public OrderMenuView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				session.setSession(new SessionController().sessionLoad());
				menuType = new SessionController().menuSelectOpen();
				User user = (User) session.getSession();
				String menuTypeTemp = null;
				switch (menuType) {
				case 1:	
					menuTypeTemp="한식";
					break;
				case 2:					
					menuTypeTemp="중식";
					break;
				case 3:					
					menuTypeTemp="일식";
					break;
				case 4:					
					menuTypeTemp="분식";
					break;
				}
				lbl_order.setText(menuTypeTemp+ " 메뉴 주문");
			}
		});
		this.setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192,57,43));
		panel.setBounds(0, 0, 794, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl_order = new JLabel("메뉴 주문");
		lbl_order.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lbl_order.setIcon(new ImageIcon("gui_imgs/ㅁㄴㅁㄴㅇㅁㄴㅇ.PNG"));
		lbl_order.setBounds(86, 10, 302, 60);
		panel.add(lbl_order);
		
		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_selectCategory_1.png"));
		title_icon.setBounds(12, 10, 62, 60);
		panel.add(title_icon);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lbl_logo.setBounds(666, 3, 99, 73);
		panel.add(lbl_logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(403, 127, 379, 435);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_img = new JLabel("메뉴판");
		lbl_img.setFont(new Font("굴림", Font.BOLD, 15));
		
		lbl_img.setForeground(Color.WHITE);
		lbl_img.setBackground(new Color(255, 255, 240));
		lbl_img.setBounds(12, 10, 121, 28);
		panel_1.add(lbl_img);
		
		btn_order = new JButton("");
		btn_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"계산 완료"," 영수증 ",JOptionPane.WARNING_MESSAGE);
			}
		});
		btn_order.setFont(new Font("굴림", Font.BOLD, 14));
		btn_order.setIcon(new ImageIcon("gui_imgs/btn_orderMenu_1.png"));
		btn_order.setBounds(217, 391, 150, 34);
		panel_1.add(btn_order);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 48, 355, 333);
		panel_1.add(scrollPane_1);
		
		menuList = new JTable();
		menuList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uBD84\uB958", "\uBA54\uB274\uC774\uB984"
			}
		));
		scrollPane_1.setViewportView(menuList);
		
		JLabel lbl_orderTotal = new JLabel("");
		lbl_orderTotal.setBounds(12, 391, 190, 34);
		panel_1.add(lbl_orderTotal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(12, 127, 379, 435);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_img3 = new JLabel("매장 검색");
		lbl_img3.setFont(new Font("굴림", Font.BOLD, 15));
		
		lbl_img3.setForeground(Color.WHITE);
		lbl_img3.setBackground(new Color(255, 255, 240));
		lbl_img3.setBounds(12, 10, 147, 32);
		panel_2.add(lbl_img3);
		
		tf_serch = new JTextField();
		tf_serch.setBounds(12, 52, 303, 38);
		panel_2.add(tf_serch);
		tf_serch.setColumns(10);
		
		btn_serch = new JButton("");
		btn_serch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				storeList.setModel(oc.searchStore(tf_serch.getText(), dtmStore));
			}
		});
			
		btn_serch.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_1.png"));
		btn_serch.setBounds(327, 52, 40, 38);
		panel_2.add(btn_serch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 355, 325);
		panel_2.add(scrollPane);
		
		storeList = new JTable();
		storeList.setModel(dtmStore);
		scrollPane.setViewportView(storeList);
		
		btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SelectMenuView();
				dispose();
			}
		});
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBounds(682, 90, 100, 28);
		getContentPane().add(btn_back);
		
		setVisible(true);
	}

}

