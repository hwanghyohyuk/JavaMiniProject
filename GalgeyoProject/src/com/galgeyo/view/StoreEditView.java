package com.galgeyo.view;

import javax.swing.*;

import com.galgeyo.controller.SessionController;
import com.galgeyo.server.ClientController;
import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;

import java.awt.*;
import java.awt.event.*;

//매장정보 수정
public class StoreEditView extends JFrame implements Protocol {

	private JTextField tf_addr;
	private JTextField tf_storeName;
	private JTextField tf_ownNo;
	private JTextField tf_tel;
	private JPasswordField tf_modifyPw;
	private JPasswordField tf_confirmPw;
	private JButton btn_back;
	private JComboBox cb_type;

	private Session session = new Session();

	
	public StoreEditView() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				session.setSession(new SessionController().sessionLoad());
				Manager manager = (Manager) session.getSession();
				tf_storeName.setText(manager.getName());
				tf_ownNo.setText(manager.getOwnNo());
				tf_tel.setText(manager.getTel());
				tf_addr.setText(manager.getAddr());
				cb_type.setSelectedItem(manager.getType());
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

		JLabel title_text = new JLabel("매장 정보 수정");
		title_text.setIcon(null);
		title_text.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		title_text.setBounds(86, 10, 302, 60);
		panel.add(title_text);

		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_storeInfoEdit_1.png"));
		title_icon.setBounds(12, 10, 62, 60);
		panel.add(title_icon);

		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lbl_logo.setBounds(666, 3, 99, 73);
		panel.add(lbl_logo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 90, 794, 482);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_7.setBounds(50, 10, 49, 47);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon("gui_imgs/icon_storeInfoEdit_2.png"));

		JLabel lblNewLabel_4 = new JLabel("수정할 정보를 입력해주세요.");
		lblNewLabel_4.setForeground(new Color(42, 66, 80));
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_4.setBounds(106, 28, 278, 29);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_1 = new JLabel("매장 이름");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(74, 82, 81, 29);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("사업자번호");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(74, 134, 81, 28);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3.setBounds(74, 194, 80, 28);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("주소");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_5.setBounds(74, 245, 81, 28);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_8 = new JLabel("업종");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_8.setBounds(74, 298, 57, 29);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("수정할 비밀번호");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_9.setBounds(74, 361, 125, 15);
		panel_1.add(lblNewLabel_9);

		JLabel label_1 = new JLabel("비밀번호 확인");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label_1.setBounds(74, 408, 101, 15);
		panel_1.add(label_1);

		tf_storeName = new JTextField();
		tf_storeName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_storeName.setBounds(211, 82, 198, 28);
		panel_1.add(tf_storeName);
		tf_storeName.setColumns(10);

		tf_ownNo = new JTextField();
		tf_ownNo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_ownNo.setBounds(211, 134, 198, 28);
		panel_1.add(tf_ownNo);
		tf_ownNo.setColumns(10);

		tf_tel = new JTextField();
		tf_tel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_tel.setBounds(211, 193, 198, 28);
		panel_1.add(tf_tel);
		tf_tel.setColumns(10);

		tf_addr = new JTextField();
		tf_addr.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_addr.setBounds(212, 244, 350, 28);
		panel_1.add(tf_addr);
		tf_addr.setColumns(10);

		cb_type = new JComboBox();
		cb_type.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		cb_type.setForeground(Color.BLACK);
		cb_type.setModel(new DefaultComboBoxModel(new String[] {"한식", "중식", "일식", "분식"}));
		cb_type.setBounds(212, 295, 197, 34);
		panel_1.add(cb_type);

		tf_modifyPw = new JPasswordField();
		tf_modifyPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_modifyPw.setColumns(10);
		tf_modifyPw.setBounds(211, 354, 198, 28);
		panel_1.add(tf_modifyPw);

		tf_confirmPw = new JPasswordField();
		tf_confirmPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_confirmPw.setColumns(10);
		tf_confirmPw.setBounds(212, 400, 198, 28);
		panel_1.add(tf_confirmPw);

		JButton btn_submit = new JButton("");
		btn_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Session clone = new Session();
				Manager manager = (Manager) session.getSession();
				clone.setSession(manager);
				Manager cloneManager =  (Manager) clone.getSession();
				if(tf_storeName.getText().equals("")){
					JOptionPane.showMessageDialog(null,"매장 이름를 입력해주세요.","매장정보 수정 오류",JOptionPane.WARNING_MESSAGE);
				}else if(tf_ownNo.getText().equals("")){
					JOptionPane.showMessageDialog(null,"사업자 번호를 입력해주세요.","매장정보 수정 오류",JOptionPane.WARNING_MESSAGE);
				}else if(tf_tel.getText().equals("")){
					JOptionPane.showMessageDialog(null,"전화번호를 입력해주세요.","매장정보 수정 오류",JOptionPane.WARNING_MESSAGE);
				}else if(tf_addr.getText().equals("")){
					JOptionPane.showMessageDialog(null,"주소를 입력해주세요.","매장정보 수정 오류",JOptionPane.WARNING_MESSAGE);
				}else{
					if(!tf_storeName.getText().equals(manager.getName())){//변경사항확인
						cloneManager.setName(tf_storeName.getText());
					}
					if(!tf_ownNo.getText().equals(manager.getOwnNo())){
						cloneManager.setOwnNo(tf_ownNo.getText());
					}
					if(!tf_tel.getText().equals(manager.getTel())){
						cloneManager.setTel(tf_tel.getText());
					}
					if(!tf_addr.getText().equals(manager.getAddr())){
						cloneManager.setAddr(tf_addr.getText());
					}
					if(!cb_type.getSelectedItem().equals(manager.getType())){
						cloneManager.setType((String)cb_type.getSelectedItem());
					}					
					if(!tf_modifyPw.getText().equals("")){//비밀번호 수정하면
						if(tf_confirmPw.getText().equals("")){//비밀번호 확인이 빈칸이면
							JOptionPane.showMessageDialog(null,"수정할 비밀번호와 같은 비밀번호를 입력해주세요","매장정보 수정 오류",JOptionPane.WARNING_MESSAGE);
						}else{//비밀번호 확인이 빈칸이 아니면
							if(tf_modifyPw.getText().equals(tf_confirmPw.getText())){//수정과 확인이 같다면
								cloneManager.setPwd(tf_modifyPw.getText());
								submit(cloneManager);
							}else{//수정과 확인이 다르다면
								JOptionPane.showMessageDialog(null,"수정할 비밀번호와 같은 비밀번호를 입력해주세요","매장정보 수정 오류",JOptionPane.WARNING_MESSAGE);
							}
						}
					}else{
						submit(cloneManager);
					}					
				}
			}
		});
		btn_submit.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_submit.setIcon(new ImageIcon("gui_imgs/btn_menuEdit_3.png"));
		btn_submit.setBounds(650, 400, 107, 51);
		panel_1.add(btn_submit);

		btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ManagerMainView();
				dispose();
			}
		});
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(682, 0, 100, 28);
		panel_1.add(btn_back);

		this.setVisible(true);
	}
	
	private void submit(Manager cloneManager){
		Manager message = cloneManager;
		Object result = new ClientController().send(POST, EDIT_USER_INFO, message);
		if(result instanceof Boolean){
			boolean check = (boolean)result;
			if(check){
				JOptionPane.showMessageDialog(null,"매장정보가 성공적으로 수정되었습니다.","매장정보 수정 성공",JOptionPane.INFORMATION_MESSAGE);
				new SessionController().sessionSave(cloneManager);
				new ManagerMainView();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null,"매장정보를 업로드하는데 실패하였습니다.","매장정보 수정 실패",JOptionPane.ERROR_MESSAGE);
				new ManagerMainView();
				dispose();
			}
		}
	}
}
