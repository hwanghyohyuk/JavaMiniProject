package com.galgeyo.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.galgeyo.controller.SessionController;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;

//주문 통계
public class TotalOrderView extends JFrame {

	private JLabel lbl_text1;
	private JLabel lbl_text2;
	private JLabel lbl_text3;

	private JTable table1;

	private int todayTotal = 0; // 오늘의 총 매출 금액
	private int monthTotal = 0; // 이번 달 총 매출 금액
	private int monthAvg = 0; // 이번 달 평균 매출 금액

	private Session session = new Session();
	private JTable table;

	public TotalOrderView() {
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
		panel.setLayout(null);
		getContentPane().add(panel);

		JLabel title_text = new JLabel("주문내역통계");
		title_text.setIcon(null);
		title_text.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		title_text.setBounds(86, 10, 302, 60);
		panel.add(title_text);

		JLabel title_icon = new JLabel();
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_totalOrder_1.png"));
		title_icon.setBounds(12, 10, 62, 60);
		panel.add(title_icon);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		logo.setBounds(666, 3, 99, 73);
		panel.add(logo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 90, 772, 472);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbl_text1 = new JLabel("오늘의 총 매출 금액은 " + todayTotal + "원 입니다.");
		lbl_text1.setBounds(0, 0, 663, 40);
		lbl_text1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_text1.setForeground(new Color(44, 62, 80));

		lbl_text2 = new JLabel("이번 달의 총 매출 금액 : " + monthTotal + "원");
		lbl_text2.setIcon(new ImageIcon("gui_imgs/icon_totalOrder_2.png"));
		lbl_text2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lbl_text2.setBounds(0, 60, 400, 40);
		lbl_text2.setForeground(new Color(44, 62, 80));

		lbl_text3 = new JLabel("평균 매출 금액 : " + monthAvg + "원");
		lbl_text3.setIcon(new ImageIcon("gui_imgs/icon_totalOrder_2.png"));
		lbl_text3.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		lbl_text3.setBounds(400, 60, 372, 40);
		lbl_text3.setForeground(new Color(44, 62, 80));

		panel_1.add(lbl_text1);
		panel_1.add(lbl_text2);
		panel_1.add(lbl_text3);

		JScrollPane scp = new JScrollPane(table1);
		scp.setBounds(0, 110, 772, 362);
		panel_1.add(scp);
		
		table = new JTable();
		scp.setViewportView(table);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ManagerMainView();
				dispose();
			}
		});
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBounds(675, 0, 97, 23);
		panel_1.add(btn_back);

		setVisible(true);
	}
}
