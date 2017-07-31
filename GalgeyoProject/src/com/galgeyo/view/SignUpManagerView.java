package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;

//관리자 회원가입
public class SignUpManagerView extends JFrame {

	private JTextField tf_id;
	private JTextField tf_pwd;
	private JTextField tf_storeName;
	private JTextField tf_ownNo;
	private JTextField tf_addr;
	private JTextField tf_tel;

	public SignUpManagerView() {
		this.setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lbl_regImg = new JLabel("");
		lbl_regImg.setIcon(new ImageIcon("gui_imgs/icon_signUp_2.png"));
		lbl_regImg.setBounds(50, 62, 57, 53);
		getContentPane().add(lbl_regImg);

		JLabel lbl_reg = new JLabel("회원가입");
		lbl_reg.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbl_reg.setBounds(119, 62, 112, 53);
		getContentPane().add(lbl_reg);

		JLabel lbl_regDes = new JLabel("회원님의 정보를 입력해주세요.");
		lbl_regDes.setBounds(85, 125, 200, 30);
		getContentPane().add(lbl_regDes);

		JLabel lbl_id = new JLabel("아이디");
		lbl_id.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_id.setBounds(50, 179, 100, 28);
		getContentPane().add(lbl_id);

		JLabel lbl_pwd = new JLabel("비밀번호");
		lbl_pwd.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_pwd.setBounds(50, 219, 100, 28);
		getContentPane().add(lbl_pwd);

		JLabel lbl_storeName = new JLabel("매장 이름");
		lbl_storeName.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_storeName.setBounds(50, 259, 100, 28);
		getContentPane().add(lbl_storeName);

		JLabel lbl_ownNo = new JLabel("사업자 번호");
		lbl_ownNo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_ownNo.setBounds(50, 299, 100, 28);
		getContentPane().add(lbl_ownNo);

		JLabel lbl_addr = new JLabel("주소");
		lbl_addr.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_addr.setBounds(50, 339, 100, 28);
		getContentPane().add(lbl_addr);

		JLabel lbl_tel = new JLabel("전화번호");
		lbl_tel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_tel.setBounds(50, 379, 100, 28);
		getContentPane().add(lbl_tel);

		JLabel lbl_type = new JLabel("업종");
		lbl_type.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lbl_type.setBounds(50, 419, 100, 28);
		getContentPane().add(lbl_type);

		tf_id = new JTextField();
		tf_id.setBounds(160, 179, 206, 28);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);

		tf_pwd = new JTextField();
		tf_pwd.setBounds(160, 219, 206, 28);
		getContentPane().add(tf_pwd);
		tf_pwd.setColumns(10);

		tf_storeName = new JTextField();
		tf_storeName.setBounds(160, 259, 206, 28);
		getContentPane().add(tf_storeName);
		tf_storeName.setColumns(10);

		tf_ownNo = new JTextField();
		tf_ownNo.setBounds(160, 299, 206, 28);
		getContentPane().add(tf_ownNo);
		tf_ownNo.setColumns(10);

		tf_addr = new JTextField();
		tf_addr.setBounds(160, 339, 207, 28);
		getContentPane().add(tf_addr);
		tf_addr.setColumns(10);

		tf_tel = new JTextField();
		tf_tel.setBounds(160, 379, 207, 28);
		getContentPane().add(tf_tel);
		tf_tel.setColumns(10);

		JButton btn_confirmId = new JButton("");
		btn_confirmId.setIcon(new ImageIcon("gui_imgs/btn_signUp_3.png"));
		btn_confirmId.setBounds(378, 179, 80, 28);
		getContentPane().add(btn_confirmId);

		JButton btn_back = new JButton("뒤로가기");
		btn_back.setBounds(382, 10, 100, 25);
		getContentPane().add(btn_back);

		JButton btn_submit = new JButton("");
		btn_submit.setIcon(new ImageIcon("gui_imgs/btn_signUp_4.png"));
		btn_submit.setBounds(174, 476, 151, 65);
		getContentPane().add(btn_submit);

		JComboBox cb_type = new JComboBox();
		cb_type.setModel(new DefaultComboBoxModel(new String[] { "한식", "중식", "양식", "일식" }));
		cb_type.setBounds(160, 424, 206, 28);
		getContentPane().add(cb_type);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SignUpManagerView();
	}
}
