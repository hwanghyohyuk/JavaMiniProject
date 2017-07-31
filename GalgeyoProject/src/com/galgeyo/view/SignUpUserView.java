package com.galgeyo.view;

import javax.swing.*;
import java.awt.*;

//사용자 회원가입
public class SignUpUserView extends JFrame {
	private JTextField tf_id;
	private JTextField tf_name;
	private JTextField tf_tel;
	private JTextField tf_pwd;

	public SignUpUserView() {
		this.setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lbl_regImg = new JLabel("");
		lbl_regImg.setIcon(new ImageIcon("gui_imgs/icon_signUp_2.png"));
		lbl_regImg.setBounds(60, 62, 57, 54);
		getContentPane().add(lbl_regImg);

		JLabel lbl_reg = new JLabel("회원가입");
		lbl_reg.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lbl_reg.setBounds(129, 74, 82, 42);
		getContentPane().add(lbl_reg);

		JLabel lbl_regDes = new JLabel("회원님의 정보를 입력해주세요.");
		lbl_regDes.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_regDes.setBounds(73, 126, 168, 15);
		getContentPane().add(lbl_regDes);

		JLabel lbl_id = new JLabel("아이디");
		lbl_id.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_id.setBounds(73, 186, 57, 15);
		getContentPane().add(lbl_id);

		JLabel lbl_pwd = new JLabel("비밀번호");
		lbl_pwd.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_pwd.setBounds(73, 221, 57, 32);
		getContentPane().add(lbl_pwd);

		JLabel lbl_name = new JLabel("이름");
		lbl_name.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_name.setBounds(73, 266, 57, 29);
		getContentPane().add(lbl_name);

		JLabel lbl_tel = new JLabel("핸드폰번호");
		lbl_tel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lbl_tel.setBounds(73, 305, 69, 31);
		getContentPane().add(lbl_tel);

		tf_id = new JTextField();
		tf_id.setBounds(154, 179, 192, 32);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);

		tf_pwd = new JTextField();
		tf_pwd.setBounds(154, 225, 192, 28);
		getContentPane().add(tf_pwd);
		tf_pwd.setColumns(10);

		tf_name = new JTextField();
		tf_name.setBounds(154, 266, 192, 29);
		getContentPane().add(tf_name);
		tf_name.setColumns(10);

		tf_tel = new JTextField();
		tf_tel.setBounds(154, 308, 192, 28);
		getContentPane().add(tf_tel);
		tf_tel.setColumns(10);

		JButton btn_confirmId = new JButton("");
		btn_confirmId.setIcon(new ImageIcon("gui_imgs/btn_signUp_3.png"));
		btn_confirmId.setBounds(358, 179, 82, 32);
		getContentPane().add(btn_confirmId);

		JButton btn_submit = new JButton("");
		btn_submit.setIcon(new ImageIcon("gui_imgs/btn_signUp_4.png"));
		btn_submit.setBounds(175, 441, 150, 65);
		getContentPane().add(btn_submit);

		JButton btn_back = new JButton("뒤로가기");
		btn_back.setBounds(382, 10, 100, 25);
		getContentPane().add(btn_back);

		this.setVisible(true);
	}

}
