package com.galgeyo.client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.galgeyo.client.SessionController;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//메뉴선택
public class SelectMenuView extends JFrame {
	private JButton btn_hansic, btn_joongsic, btn_illsic, btn_boonsic, btn_back;
	private Session session = new Session();
	
	public SelectMenuView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				session.setSession(new SessionController().sessionLoad());
				User user = (User) session.getSession();
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

		JLabel lbl_menuSelect = new JLabel("메뉴 선택");
		lbl_menuSelect.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lbl_menuSelect.setBounds(86, 10, 302, 60);
		panel.add(lbl_menuSelect);
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lbl_logo.setBounds(666, 3, 99, 73);
		panel.add(lbl_logo);

		JLabel lbl_Img2 = new JLabel("");
		lbl_Img2.setIcon(new ImageIcon("gui_imgs/icon_selectCategory_1.png"));
		lbl_Img2.setBounds(12, 10, 62, 60);
		panel.add(lbl_Img2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 90, 794, 482);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btn_hansic = new JButton("");
		btn_hansic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SessionController().menuSelectSave(1);
				new OrderMenuView();
				dispose();
			}
		});
		btn_hansic.setIcon(new ImageIcon("gui_imgs/btn_selectCategory_1.png"));
		btn_hansic.setBounds(46, 10, 273, 226);
		panel_1.add(btn_hansic);

		btn_joongsic = new JButton("");
		btn_joongsic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SessionController().menuSelectSave(2);
				new OrderMenuView();
				dispose();
			}
		});
		btn_joongsic.setIcon(new ImageIcon("gui_imgs/btn_selectCategory_2.png"));
		btn_joongsic.setBounds(363, 10, 273, 226);
		panel_1.add(btn_joongsic);

		btn_illsic = new JButton("");
		btn_illsic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SessionController().menuSelectSave(3);
				new OrderMenuView();
				dispose();
			}
		});
		btn_illsic.setIcon(new ImageIcon("gui_imgs/btn_selectCategory_3.png"));
		btn_illsic.setBounds(46, 246, 273, 226);
		panel_1.add(btn_illsic);

		btn_boonsic = new JButton("");
		btn_boonsic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SessionController().menuSelectSave(4);
				new OrderMenuView();
				dispose();
			}
		});
		btn_boonsic.setIcon(new ImageIcon("gui_imgs/btn_selectCategory_5.png"));
		btn_boonsic.setBounds(363, 246, 273, 226);
		panel_1.add(btn_boonsic);

		btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserMainView();
				dispose();
			}
		});
		btn_back.setBackground(Color.WHITE);
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBounds(682, 0, 100, 28);
		panel_1.add(btn_back);
		setVisible(true);

	}
}
