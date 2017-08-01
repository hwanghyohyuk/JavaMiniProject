package com.galgeyo.view;

import javax.swing.*;

import com.galgeyo.controller.SessionController;
import com.galgeyo.server.ClientController;
import com.galgeyo.server.ClientSender;
import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Packet;
import com.galgeyo.vo.User;

import java.awt.*;
import java.awt.event.*;

//로그인화면
public class LoginView extends JFrame implements Protocol{
	private JTextField tf_id;
	private JTextField tf_pwd;

	public LoginView() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lbl_logoImg = new JLabel("");
		lbl_logoImg.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_1.png"));
		lbl_logoImg.setBackground(Color.WHITE);
		lbl_logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logoImg.setBounds(12, 10, 470, 348);
		getContentPane().add(lbl_logoImg);

		tf_id = new JTextField();
		tf_id.setToolTipText("");
		tf_id.setBounds(121, 368, 163, 36);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);

		tf_pwd = new JTextField();
		tf_pwd.setBounds(121, 418, 163, 35);
		getContentPane().add(tf_pwd);
		tf_pwd.setColumns(10);

		JButton btn_login = new JButton("");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 로그인
				String message = tf_id.getText()+"/"+tf_pwd.getText();
				System.out.println(message);
				Object result = new ClientController().send(POST, LOGIN, message);
				if(result instanceof Boolean){
					boolean check = (boolean) result;
					if(check){
						JOptionPane.showMessageDialog(null,"비밀번호가 맞지않습니다.","로그인 오류",JOptionPane.ERROR_MESSAGE); 
					}else{
						JOptionPane.showMessageDialog(null,"존재하지 않는 아이디입니다.","로그인 오류",JOptionPane.ERROR_MESSAGE); 
					}
				}else if(result instanceof User){
					JOptionPane.showMessageDialog(null,"로그인 성공","알림",JOptionPane.INFORMATION_MESSAGE);
					new SessionController().sessionSave(result);
					new UserMainView();
					dispose();
				}else if(result instanceof Manager){
					JOptionPane.showMessageDialog(null,"로그인 성공","알림",JOptionPane.INFORMATION_MESSAGE);
					new SessionController().sessionSave(result);
					new ManagerMainView();
					dispose();
				}
			}
		});
		btn_login.setBackground(Color.WHITE);
		btn_login.setIcon(new ImageIcon("gui_imgs/btn_login_3.png"));
		btn_login.setBounds(296, 368, 98, 85);
		getContentPane().add(btn_login);

		JLabel lbl_idImg = new JLabel("");
		lbl_idImg.setIcon(new ImageIcon("gui_imgs/icon_login_1.png"));
		lbl_idImg.setBounds(90, 368, 34, 34);
		getContentPane().add(lbl_idImg);

		JLabel lbl_pwdImg = new JLabel("");
		lbl_pwdImg.setIcon(new ImageIcon("gui_imgs/icon_login_2.png"));
		lbl_pwdImg.setBounds(90, 418, 34, 36);
		getContentPane().add(lbl_pwdImg);

		JLabel lbl_regImg = new JLabel("");
		lbl_regImg.setIcon(new ImageIcon("gui_imgs/btn_login_1.png"));
		lbl_regImg.setBounds(90, 474, 41, 40);
		getContentPane().add(lbl_regImg);

		JLabel lbl_reg = new JLabel("회원가입");
		lbl_reg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUpView();
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_reg.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_reg.setForeground(Color.BLACK);
			}
		});
		lbl_reg.setBounds(131, 478, 69, 36);
		getContentPane().add(lbl_reg);

		JLabel lbl_findInfoImg = new JLabel("");
		lbl_findInfoImg.setIcon(new ImageIcon("gui_imgs/btn_login_2.png"));
		lbl_findInfoImg.setBounds(286, 478, 34, 36);
		getContentPane().add(lbl_findInfoImg);

		JLabel lblfindInfo = new JLabel("ID/PW 찾기");
		lblfindInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FindInfoView();
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblfindInfo.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblfindInfo.setForeground(Color.BLACK);
			}
		});
		lblfindInfo.setBounds(324, 478, 70, 36);
		getContentPane().add(lblfindInfo);

		setVisible(true);

	}
}
