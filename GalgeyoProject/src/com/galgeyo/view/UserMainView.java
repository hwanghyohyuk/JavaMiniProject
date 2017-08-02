package com.galgeyo.view;

import com.galgeyo.controller.SessionController;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.User;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 사용자 메인화면

public class UserMainView extends JFrame {
	private JTable table;
	private JTable table_1;
	private JButton btn_editInfo;
	private JButton btn_startOrder;
	private JLabel lbl_userName;
	private JLabel lbl_userId;
	private Session session = new Session();

	public UserMainView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				session.setSession(new SessionController().sessionLoad());
				User user = (User)session.getSession();
				lbl_userName.setText(user.getName());
				lbl_userId.setText(user.getId());
				//즐겨찾기리스트 초기화
				//최근주문내역 초기화
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

		JLabel title_text = new JLabel("마이페이지");
		title_text.setIcon(null);
		title_text.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		title_text.setBounds(86, 10, 302, 60);
		panel.add(title_text);
		
		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_user_1.png"));
		title_icon.setBounds(12, 10, 62, 60);
		panel.add(title_icon);

		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lbl_logo.setBounds(666, 3, 99, 73);
		panel.add(lbl_logo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 90, 772, 143);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_Img1 = new JLabel("");
		lbl_Img1.setBounds(0, 0, 154, 143);
		panel_1.add(lbl_Img1);
		lbl_Img1.setIcon(new ImageIcon("gui_imgs/thumbnail_img_sample.PNG"));

		lbl_userName = new JLabel("사용자 이름");
		lbl_userName.setForeground(Color.DARK_GRAY);
		lbl_userName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lbl_userName.setBounds(166, 28, 270, 29);
		panel_1.add(lbl_userName);

		lbl_userId = new JLabel("사용자 아이디");
		lbl_userId.setForeground(Color.DARK_GRAY);
		lbl_userId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_userId.setBounds(176, 67, 270, 23);
		panel_1.add(lbl_userId);

		JButton btn_logout = new JButton("로그아웃");
		btn_logout.setBackground(Color.WHITE);
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) { // 캔슬이면 2 리턴 ok는 종료
					new SessionController().deleteSession(session);
					new LoginView();
					dispose();
				}
			}
		});
		btn_logout.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_logout.setBounds(672, 0, 100, 28);
		panel_1.add(btn_logout);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(44, 62, 80));
		panel_2.setBounds(0, 243, 794, 60);
		getContentPane().add(panel_2);

		JLabel lbl_userMenu = new JLabel("User menu");
		lbl_userMenu.setForeground(Color.WHITE);
		lbl_userMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lbl_userMenu.setBounds(16, 6, 228, 46);
		panel_2.add(lbl_userMenu);

		btn_editInfo = new JButton("");
		btn_editInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new UserInfoEditView();
				dispose();
			}
		});
		btn_editInfo.setFont(new Font("굴림", Font.BOLD, 13));
		btn_editInfo.setBounds(490, 12, 140, 40);
		panel_2.add(btn_editInfo);
		btn_editInfo.setIcon(new ImageIcon("gui_imgs/btn_user_1.png"));

		// 주문하기 버튼 누르면 메뉴선택 화면으로 이동
		btn_startOrder = new JButton("");
		btn_startOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SelectMenuView();
				dispose();
			}
		});
		btn_startOrder.setIcon(new ImageIcon("gui_imgs/btn_orderMenu_1.png"));
		btn_startOrder.setFont(new Font("굴림", Font.BOLD, 13));
		btn_startOrder.setBounds(642, 12, 140, 40);
		panel_2.add(btn_startOrder);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 313, 380, 249);
		getContentPane().add(panel_3);

		JLabel lbl_favorite = new JLabel("즐겨찾기");
		lbl_favorite.setForeground(new Color(245, 245, 245));
		lbl_favorite.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_favorite.setBounds(12, 8, 144, 27);
		panel_3.add(lbl_favorite);

		table = new JTable();
		table.setBounds(12, 41, 353, 198);
		panel_3.add(table);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(402, 313, 380, 249);
		getContentPane().add(panel_4);

		JLabel lbl_recentlyOrder = new JLabel("최근 주문 내역");
		lbl_recentlyOrder.setForeground(new Color(245, 245, 245));
		lbl_recentlyOrder.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbl_recentlyOrder.setBounds(12, 8, 144, 27);
		panel_4.add(lbl_recentlyOrder);

		table_1 = new JTable();
		table_1.setBounds(12, 41, 359, 198);
		panel_4.add(table_1);

		setVisible(true);
	}
}
