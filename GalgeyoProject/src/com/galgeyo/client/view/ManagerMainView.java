package com.galgeyo.client.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.galgeyo.client.ClientController;
import com.galgeyo.client.SessionController;
import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Order;
import com.galgeyo.vo.OrderList;
import com.galgeyo.vo.Session;

import java.awt.event.*;
import java.util.ArrayList;

//관리자 메인화면
public class ManagerMainView extends JFrame implements Protocol {

	private JTable tb_wait;
	private JTable tb_reserv;
	private JLabel lbl_storeName;
	private JLabel lbl_managerId;
	private JButton btn_booking;
	private JButton btn_apply1;
	private JButton btn_apply2;
	
	private Session session = new Session();

	private DefaultTableModel dtmWaiting = new DefaultTableModel(new Object[][] {},
			new String[] { "주문번호", "주문자", "전화번호", "예약시간" }) { // 셀 수정 못하게 하는 부분
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private DefaultTableModel dtmOrder = new DefaultTableModel(new Object[][] {},
			new String[] { "주문번호", "주문자", "전화번호", "예약시간", "상태" }) { // 셀 수정 못하게
																	// 하는 부분
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	public ManagerMainView() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				session.setSession(new SessionController().sessionLoad());
				Manager manager = (Manager) session.getSession();
				lbl_storeName.setText(manager.getName());
				lbl_managerId.setText(manager.getId());
				boolean check = manager.isOpen();
				if (check) {
					btn_booking.setIcon(new ImageIcon("gui_imgs/btn_manager_1-2.png"));
				} else {
					btn_booking.setIcon(new ImageIcon("gui_imgs/btn_manager_1.png"));
				}
				String message = manager.getId();
				Object result = new ClientController().send(GET, ANSWER_WAIT_LIST, message);
				if (result instanceof OrderList) {
					OrderList orderlist = (OrderList) result;
					ArrayList<Order> order = orderlist.getOrderList();
					Object[][] resultList = new Object[order.size()][6];
					for (int i = 0; i < resultList.length; i++) {
						resultList[i][0] = ((Order) (order.get(i))).getOrderNo();
						resultList[i][1] = ((Order) (order.get(i))).getName();
						resultList[i][2] = ((Order) (order.get(i))).getTel();
						resultList[i][3] = ((Order) (order.get(i))).getReservation();
					}
					for (int i = 0; i < resultList.length; i++) {
						dtmWaiting.addRow(resultList[i]);
					}
					tb_wait.setModel(dtmWaiting);
				}
				Object result2 = new ClientController().send(GET, ORDER_LIST, message);
				if (result2 instanceof OrderList) {
					OrderList orderlist = (OrderList) result2;
					ArrayList<Order> order = orderlist.getOrderList();
					Object[][] resultList = new Object[order.size()][6];
					for (int i = 0; i < resultList.length; i++) {
						resultList[i][0] = ((Order) (order.get(i))).getOrderNo();
						resultList[i][1] = ((Order) (order.get(i))).getName();
						resultList[i][2] = ((Order) (order.get(i))).getTel();
						resultList[i][3] = ((Order) (order.get(i))).getReservation();
						resultList[i][4] = ((Order) (order.get(i))).isAcceptOrder();
					}
					for (int i = 0; i < resultList.length; i++) {
						dtmOrder.addRow(resultList[i]);
					}
					tb_reserv.setModel(dtmOrder);
				}
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

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		logo.setBounds(666, 3, 99, 73);
		panel.add(logo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 90, 772, 143);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel imgLabel_preview = new JLabel("");
		imgLabel_preview.setBounds(0, 0, 154, 143);
		panel_1.add(imgLabel_preview);
		imgLabel_preview.setIcon(new ImageIcon("gui_imgs/thumbnail_img_sample.PNG"));

		lbl_storeName = new JLabel("매장 이름");
		lbl_storeName.setForeground(Color.DARK_GRAY);
		lbl_storeName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lbl_storeName.setBounds(166, 17, 270, 29);
		panel_1.add(lbl_storeName);

		lbl_managerId = new JLabel("관리자 아이디");
		lbl_managerId.setForeground(Color.DARK_GRAY);
		lbl_managerId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_managerId.setBounds(176, 56, 260, 23);
		panel_1.add(lbl_managerId);

		btn_booking = new JButton("");
		btn_booking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 예약 가능 / 불가능
				Manager manager = (Manager) session.getSession();
				Object result = new ClientController().send(POST, CHANGE_RESER_STATUS, manager);
				boolean check = (boolean) result;
				if (check) {
					btn_booking.setIcon(new ImageIcon("gui_imgs/btn_manager_1-2.png"));
					manager.setOpen(check);
					new SessionController().sessionSave(manager);
				} else {
					btn_booking.setIcon(new ImageIcon("gui_imgs/btn_manager_1.png"));
					manager.setOpen(check);
					new SessionController().sessionSave(manager);
				}
			}
		});
		btn_booking.setBackground(Color.WHITE);
		btn_booking.setBounds(166, 88, 250, 45);
		panel_1.add(btn_booking);

		JButton btn_logout = new JButton("로그아웃");
		btn_logout.setFont(new Font("맑은 고딕", Font.BOLD, 12));
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
		btn_logout.setBackground(Color.WHITE);
		btn_logout.setBounds(672, 0, 100, 28);
		panel_1.add(btn_logout);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44, 62, 80));

		panel_2.setBounds(0, 243, 794, 60);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lavel_managementMenu = new JLabel("Management menu");
		lavel_managementMenu.setForeground(new Color(255, 255, 255));
		lavel_managementMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lavel_managementMenu.setBounds(16, 6, 228, 46);
		panel_2.add(lavel_managementMenu);

		JButton btn_storeInfoEdit = new JButton("");
		btn_storeInfoEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 매장정보수정
				new StoreEditView();
				dispose();
			}
		});
		btn_storeInfoEdit.setBounds(470, 6, 170, 46);
		panel_2.add(btn_storeInfoEdit);
		btn_storeInfoEdit.setIcon(new ImageIcon("gui_imgs/btn_manager_2.png"));

		JButton btn_menuManagement = new JButton("");
		btn_menuManagement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 메뉴관리
				new MenuManagementView();
				dispose();
			}
		});
		btn_menuManagement.setIcon(new ImageIcon("gui_imgs/btn_manager_3.png"));
		btn_menuManagement.setBounds(652, 6, 130, 46);
		panel_2.add(btn_menuManagement);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 64, 64));
		panel_3.setBounds(10, 313, 380, 249);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel label_listTitle1 = new JLabel("응답 대기자 리스트");
		label_listTitle1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label_listTitle1.setForeground(new Color(245, 245, 245));
		label_listTitle1.setBounds(12, 8, 144, 27);
		panel_3.add(label_listTitle1);

		btn_apply1 = new JButton("");
		btn_apply1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manager manager = (Manager) session.getSession();
				int row = tb_wait.getSelectedRow();
				String orderNo = (String) tb_wait.getValueAt(row, 0);
				String message = orderNo + "," + manager.getId();
				Object result = new ClientController().send(POST, ACCEPT_ORDER, message);
				if (result instanceof Boolean) {
					boolean check = (boolean) result;
					if (check) {
						JOptionPane.showMessageDialog(null, "예약을 승낙하였습니다.", "예약 승낙", JOptionPane.INFORMATION_MESSAGE);
						Object[] rowdata = { tb_wait.getValueAt(row, 0), tb_wait.getValueAt(row, 1),
								tb_wait.getValueAt(row, 2), tb_wait.getValueAt(row, 3), true };
						dtmOrder.addRow(rowdata);
						dtmWaiting.removeRow(row);
					} else {
						JOptionPane.showMessageDialog(null, "오류 발생.", "오류 발생", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btn_apply1.setIcon(new ImageIcon("gui_imgs/btn_manager_5.png"));
		btn_apply1.setBounds(286, 210, 82, 30);
		panel_3.add(btn_apply1);

		btn_apply2 = new JButton("");
		btn_apply2.setBounds(12, 210, 82, 30);
		panel_3.add(btn_apply2);
		btn_apply2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 응답대기자
				Manager manager = (Manager) session.getSession();
				int row = tb_wait.getSelectedRow();
				String orderNo = (String) tb_wait.getValueAt(row, 0);
				String message = orderNo + "," + manager.getId();
				Object result = new ClientController().send(POST, ACCEPT_CANCEL, message);
				if (result instanceof Boolean) {
					boolean check = (boolean) result;
					if (check) {
						JOptionPane.showMessageDialog(null, "예약을 거절하였습니다.", "예약 거절", JOptionPane.INFORMATION_MESSAGE);
						dtmWaiting.removeRow(row);
					} else {
						JOptionPane.showMessageDialog(null, "오류 발생.", "오류 발생", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		
		btn_apply2.setIcon(new ImageIcon("gui_imgs/btn_manager_6.png"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 45, 356, 155);
		panel_3.add(scrollPane);

		tb_wait = new JTable();
		tb_wait.setModel(dtmWaiting);
		scrollPane.setViewportView(tb_wait);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(402, 313, 380, 249);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel label = new JLabel("예약 주문자 리스트");
		label.setForeground(new Color(245, 245, 245));
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		label.setBounds(12, 8, 144, 27);
		panel_4.add(label);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 45, 356, 194);
		panel_4.add(scrollPane_1);

		tb_reserv = new JTable();
		scrollPane_1.setViewportView(tb_reserv);

		setVisible(true);
	}
}
