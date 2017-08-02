package com.galgeyo.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.galgeyo.controller.SessionController;
import com.galgeyo.controller.UserInfoEditController;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.User;

//개인정보수정
public class UserInfoEditView extends JFrame {

	private JPasswordField tf_confirmPwd;
	private JTextField tf_name;
	private JTextField tf_tel;
	private JPasswordField tf_modifyPwd;
	private JButton btn_back, btn_modify;
	private Session session = new Session();

	public UserInfoEditView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				session.setSession(new SessionController().sessionLoad());
				User user = (User) session.getSession();
				tf_name.setText(user.getName());
				tf_tel.setText(user.getTel());
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
		
		JLabel lbl_editInfo = new JLabel("개인정보수정");
		lbl_editInfo.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lbl_editInfo.setBounds(86, 10, 228, 60);
		panel.add(lbl_editInfo);
		
		JLabel lbl_img1 = new JLabel("");
		lbl_img1.setIcon(new ImageIcon("gui_imgs/icon_userInfoEdit_1.png"));
		lbl_img1.setBounds(25, 7, 46, 50);
		panel.add(lbl_img1);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 79, 794, 493);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Img1 = new JLabel("");
		lbl_Img1.setBounds(65, 60, 49, 47);
		panel_1.add(lbl_Img1);
		lbl_Img1.setIcon(new ImageIcon("gui_imgs/icon_userInfoEdit_2.png"));
		
		JLabel lbl_info = new JLabel("수정할 정보를 입력해주세요.");
		lbl_info.setBounds(141, 51, 278, 63);
		lbl_info.setForeground(new Color(42, 66, 80));
		lbl_info.setFont(new Font("굴림", Font.BOLD, 16));
		panel_1.add(lbl_info);
		
		JLabel lbl_name = new JLabel("이름");
		lbl_name.setBounds(85, 172, 81, 29);
		lbl_name.setFont(new Font("굴림", Font.BOLD, 14));
		panel_1.add(lbl_name);
		
		JLabel lbl_tel = new JLabel("전화번호");
		lbl_tel.setBounds(85, 243, 81, 29);
		lbl_tel.setFont(new Font("돋움", Font.BOLD, 14));
		panel_1.add(lbl_tel);
		
		JLabel lbl_EditPwd = new JLabel("수정할 비밀번호");
		lbl_EditPwd.setBounds(85, 317, 128, 29);
		lbl_EditPwd.setFont(new Font("굴림", Font.BOLD, 14));
		panel_1.add(lbl_EditPwd);
		
		JLabel lbl_confirmId = new JLabel("비밀번호 확인");
		lbl_confirmId.setBounds(85, 368, 128, 42);
		lbl_confirmId.setFont(new Font("굴림", Font.BOLD, 14));
		panel_1.add(lbl_confirmId);
		
		tf_name = new JTextField();
		tf_name.setBounds(240, 172, 195, 25);
		tf_name.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_1.add(tf_name);
		
		tf_name.setColumns(10);
		tf_tel = new JTextField();
		tf_tel.setBounds(240, 244, 195, 26);
		panel_1.add(tf_tel);
		
		tf_tel.setColumns(10);
		tf_modifyPwd = new JPasswordField();
		tf_modifyPwd.setBounds(240, 319, 195, 24);
		panel_1.add(tf_modifyPwd);
		
		tf_modifyPwd.setColumns(10);
		btn_back = new JButton("뒤로가기");
		btn_back.setBounds(682, 10, 100, 30);
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserMainView();
				dispose();
			}
		});
		btn_back.setFont(new Font("굴림", Font.BOLD, 12));
		tf_confirmPwd = new JPasswordField();
		tf_confirmPwd.setBounds(240, 375, 195, 26);
		tf_confirmPwd.setFont(new Font("굴림", Font.PLAIN, 14));
		panel_1.add(tf_confirmPwd);
		
		tf_confirmPwd.setColumns(10);
		btn_modify = new JButton("");
		btn_modify.setBounds(643, 404, 107, 51);
		btn_modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tf_modifyPwd.getText().equals(tf_confirmPwd.getText())){
					new UserInfoEditController().submitInfo(tf_name.getText(), tf_tel.getText(),tf_modifyPwd.getText(), session);
					}else{
						System.out.println("error");
					}
			}
		});
		btn_modify.setFont(new Font("굴림", Font.BOLD, 14));
		btn_modify.setIcon(new ImageIcon("gui_imgs/btn_userInfoEdit_1.png"));
		panel_1.add(btn_modify);
		panel_1.add(btn_back);
		btn_back.setBackground(Color.WHITE);
		panel_1.add(btn_back);
		this.setVisible(true);
	}
}
