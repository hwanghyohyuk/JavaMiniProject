package com.galgeyo.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import javax.swing.table.DefaultTableModel;

import com.galgeyo.server.ClientController;
import com.galgeyo.server.Protocol;
import com.galgeyo.server.SessionController;
import com.galgeyo.vo.*;
import com.galgeyo.vo.Menu;

import java.awt.event.*;
import java.util.ArrayList;

//메뉴관리 화면
public class MenuManagementView extends JFrame implements Protocol {

	private JTextField tf_menuNo;
	private JTextField tf_menuName;
	private JTextField tf_category;
	private JTextField tf_price;
	private JTextField tf_discountRate;
	private JTextField tf_searchBar;
	private JTable menuList;
	private Session session = new Session();
	private JFileChooser jfc = new JFileChooser("C:");
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton rdbtn_possible, rdbtn_impossible;
	private DefaultTableModel dtm = new DefaultTableModel(new Object[][] {},
			new String[] { "No", "메뉴이름", "가격", "주문가능" }){  //셀 수정 못하게 하는 부분
		 public boolean isCellEditable(int row, int column){
			    return false;
		 }};;

	public MenuManagementView() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				rdbtn_possible.setSelected(true);
				session.setSession(new SessionController().sessionLoad());
				Manager manager = (Manager) session.getSession();
				// 메뉴 불러오기
				String message = manager.getId();
				Object result = new ClientController().send(GET, MENU_MANAGEMENT_LIST, message);
				if (result instanceof MenuList) {
					MenuList menulist = (MenuList) result;
					ArrayList<Menu> menu = menulist.getMenuList();
					Object[][] resultList = new Object[menu.size()][6];
					for (int i = 0; i < resultList.length; i++) {
						resultList[i][0] = ((Menu) (menu.get(i))).getMenuNo();
						resultList[i][1] = ((Menu) (menu.get(i))).getMenuName();
						// resultList[i][2]=((Menu)(menu.get(i))).getCategory();
						resultList[i][2] = ((Menu) (menu.get(i))).getPrice();
						// resultList[i][4]=((Menu)(menu.get(i))).getDiscount();
						resultList[i][3] = ((Menu) (menu.get(i))).isOrderYN();
					}
					for (int i = 0; i < resultList.length; i++) {
						dtm.addRow(resultList[i]);
					}
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
		panel_1.setBackground(new Color(44, 62, 80));
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
		label.setBounds(37, 91, 57, 15);
		panel_1.add(label);

		JLabel label_1 = new JLabel("메뉴 이름");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(37, 122, 57, 15);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("분류");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(37, 153, 57, 15);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("가격");
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(37, 184, 57, 15);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("할인율");
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(37, 215, 57, 15);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("주문가능여부");
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(37, 240, 88, 47);
		panel_1.add(label_5);

		rdbtn_possible = new JRadioButton("possible");
		rdbtn_possible.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rdbtn_possible.setForeground(Color.WHITE);
		rdbtn_possible.setBackground(new Color(42, 66, 80));
		rdbtn_possible.setBounds(133, 240, 121, 23);
		panel_1.add(rdbtn_possible);

		rdbtn_impossible = new JRadioButton("impossible");
		rdbtn_impossible.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rdbtn_impossible.setForeground(Color.WHITE);
		rdbtn_impossible.setBounds(133, 265, 121, 23);
		rdbtn_impossible.setBackground(new Color(42, 66, 80));
		group.add(rdbtn_possible);
		group.add(rdbtn_impossible);

		panel_1.add(rdbtn_impossible);

		JButton btn_menuSubmit = new JButton("");
		btn_menuSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tf_menuNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "메뉴 번호를 입력해주세요.", "메뉴정보 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_menuName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "메뉴 이름를 입력해주세요.", "메뉴정보 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_category.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "분류를 입력해주세요.", "메뉴정보 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_price.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "가격을 입력해주세요.", "메뉴정보 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_discountRate.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "할인율을 입력해주세요.", "메뉴정보 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else {
					boolean yn = true;
					if (rdbtn_possible.isSelected()) {
						yn = true;
					} else if (rdbtn_impossible.isSelected()) {
						yn = false;
					}
					Manager manager = (Manager) session.getSession();
					String message = manager.getId() + "/"
							+ new Menu(tf_menuNo.getText(), tf_menuName.getText(), tf_category.getText(),
									Integer.parseInt(tf_price.getText()), Double.parseDouble(tf_discountRate.getText()),
									yn).toString();
					Object result = new ClientController().send(POST, ADD_MENU, message);
					if (result instanceof Boolean) {
						boolean check = (boolean) result;
						if (check) {
							JOptionPane.showMessageDialog(null, "메뉴정보가 성공적으로 추가되었습니다.", "메뉴정보 추가 성공",
									JOptionPane.INFORMATION_MESSAGE);
							Object[] row = { new String(tf_menuNo.getText()), new String(tf_menuName.getText()),
									new String(tf_price.getText()), new Boolean(yn), "" };
							dtm.addRow(row);
							tf_menuNo.setText("");
							tf_menuName.setText("");
							tf_category.setText("");
							tf_price.setText("");
							tf_discountRate.setText("");
							rdbtn_possible.setSelected(true);
						} else {
							JOptionPane.showMessageDialog(null, "동일한 메뉴번호가 존재합니다.", "메뉴정보 추가 실패",
									JOptionPane.ERROR_MESSAGE);
							tf_menuNo.requestFocusInWindow();
						}
					}

				}
			}
		});

		btn_menuSubmit.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_menuSubmit.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_3.png"));
		btn_menuSubmit.setBounds(173, 390, 152, 34);
		panel_1.add(btn_menuSubmit);

		tf_menuNo = new JTextField();
		tf_menuNo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_menuNo.setBounds(134, 88, 190, 21);
		panel_1.add(tf_menuNo);
		tf_menuNo.setColumns(10);

		tf_menuName = new JTextField();
		tf_menuName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_menuName.setColumns(10);
		tf_menuName.setBounds(134, 119, 190, 21);
		panel_1.add(tf_menuName);

		tf_category = new JTextField();
		tf_category.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_category.setColumns(10);
		tf_category.setBounds(134, 150, 190, 21);
		panel_1.add(tf_category);

		tf_price = new JTextField();
		tf_price.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_price.setColumns(10);
		tf_price.setBounds(134, 181, 190, 21);
		panel_1.add(tf_price);

		tf_discountRate = new JTextField();
		tf_discountRate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_discountRate.setColumns(10);
		tf_discountRate.setBounds(134, 212, 190, 21);
		panel_1.add(tf_discountRate);
		jfc.setFileFilter(new FileNameExtensionFilter("JPG", "jpg"));
		jfc.setFileFilter(new FileNameExtensionFilter("PNG", "png"));
		// 파일 필터
		jfc.setMultiSelectionEnabled(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44, 62, 80));
		panel_2.setBounds(12, 128, 379, 434);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("메뉴 검색 및 삭제");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setBounds(12, 10, 147, 32);
		panel_2.add(lblNewLabel_3);

		tf_searchBar = new JTextField();
		tf_searchBar.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_searchBar.setBounds(12, 52, 297, 38);
		panel_2.add(tf_searchBar);
		tf_searchBar.setColumns(10);

		JButton btn_menuSearch = new JButton("");
		btn_menuSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel resultDtm = new DefaultTableModel(new Object[][] {},
						new String[] { "No", "메뉴이름", "가격", "주문가능" });
				String searchStr = tf_searchBar.getText();
				if (!searchStr.equals("")) {
					for (int i = 0; i < dtm.getRowCount(); i++) {
						if (searchStr.equals((String) dtm.getValueAt(i, 1))) {// 문자열을
							resultDtm.addRow(new Object[] { dtm.getValueAt(i, 0), dtm.getValueAt(i, 1), dtm.getValueAt(i, 2), dtm.getValueAt(i, 3) });
						}
					}
					if (resultDtm.getRowCount() == 0) {
						resultDtm.addRow(new String[] { "검색", "결과가", "없습", "니다" });
					}
					menuList.setModel(resultDtm);
				} else {
					menuList.setModel(dtm);
				}
			}
		});
		btn_menuSearch.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		btn_menuSearch.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_1.png"));
		btn_menuSearch.setBounds(321, 52, 46, 38);
		panel_2.add(btn_menuSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 355, 280);
		panel_2.add(scrollPane);

		menuList = new JTable();
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuList.setModel(dtm);
		scrollPane.setViewportView(menuList);

		JButton btn_menuDelete = new JButton("New button");
		btn_menuDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manager manager = (Manager) session.getSession();
				int row = menuList.getSelectedRow();
				System.out.println(row);
				String menuNo = (String) menuList.getValueAt(row, 0);
				String message = menuNo + "," + manager.getId();
				Object result = new ClientController().send(POST, DEL_MENU, message);
				if (result instanceof Boolean) {
					boolean check = (boolean) result;
					if (check) {// 삭제완료
						JOptionPane.showMessageDialog(null, "성공적으로 삭제되었습니다.", "메뉴 삭제 성공",
								JOptionPane.INFORMATION_MESSAGE);
					} else {// 삭제 실패
						JOptionPane.showMessageDialog(null, "삭제에 실패하였습니다.", "메뉴 삭제 실패", JOptionPane.ERROR_MESSAGE);
					}
				}
				dtm.removeRow(row);
			}
		});

		btn_menuDelete.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_menuDelete.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_2.png"));
		btn_menuDelete.setBounds(122, 390, 129, 34);
		panel_2.add(btn_menuDelete);

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
