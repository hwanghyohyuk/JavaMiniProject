package com.galgeyo.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.galgeyo.server.ClientController;
import com.galgeyo.server.Protocol;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//아이디, 패스워드 찾기
public class FindInfoView extends JFrame implements Protocol {
	private JTextField tf_IdName;
	private JTextField tf_IdTel;
	private JTextField tf_PwId;
	private JTextField tf_PwTel;

	public FindInfoView() {
		getContentPane().setFont(new Font("맑은 고딕", Font.BOLD, 14));
		getContentPane().setBackground(Color.WHITE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lbl_FindInfoImg = new JLabel("");
		lbl_FindInfoImg.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_FindInfoImg.setIcon(new ImageIcon("gui_imgs/btn_login_2.png"));
		lbl_FindInfoImg.setBounds(50, 55, 41, 44);
		getContentPane().add(lbl_FindInfoImg);

		JLabel lbl_FindInfo = new JLabel("ID/PW 찾기");
		lbl_FindInfo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_FindInfo.setBounds(103, 71, 80, 23);
		getContentPane().add(lbl_FindInfo);

		JLabel lbl_FindInfoDec = new JLabel("회원가입 시 입력한 정보로 아이디와 비밀번호를 검색합니다.");
		lbl_FindInfoDec.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl_FindInfoDec.setBounds(60, 109, 422, 15);
		getContentPane().add(lbl_FindInfoDec);

		JLabel lbl_FindIdImg = new JLabel("");
		lbl_FindIdImg.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_FindIdImg.setIcon(new ImageIcon("gui_imgs/icon_findInfo_2.png"));
		lbl_FindIdImg.setBounds(60, 202, 34, 34);
		getContentPane().add(lbl_FindIdImg);

		JLabel lbl_ = new JLabel("아이디 찾기");
		lbl_.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lbl_.setBounds(106, 202, 89, 34);
		getContentPane().add(lbl_);

		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(72, 261, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1.setBounds(72, 301, 57, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_7.setIcon(new ImageIcon("gui_imgs/icon_findInfo_2.png"));
		lblNewLabel_7.setBounds(60, 374, 34, 34);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_5 = new JLabel("비밀번호 찾기");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_5.setBounds(106, 374, 89, 34);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2.setBounds(72, 433, 57, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_3.setBounds(72, 473, 57, 15);
		getContentPane().add(lblNewLabel_3);

		tf_IdName = new JTextField();
		tf_IdName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_IdName.setBounds(145, 255, 153, 28);
		getContentPane().add(tf_IdName);
		tf_IdName.setColumns(10);

		tf_IdTel = new JTextField();
		tf_IdTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_IdTel.setBounds(145, 295, 153, 28);
		getContentPane().add(tf_IdTel);
		tf_IdTel.setColumns(10);

		tf_PwId = new JTextField();
		tf_PwId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_PwId.setBounds(145, 428, 153, 28);
		getContentPane().add(tf_PwId);
		tf_PwId.setColumns(10);

		tf_PwTel = new JTextField();
		tf_PwTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_PwTel.setBounds(145, 468, 153, 28);
		getContentPane().add(tf_PwTel);
		tf_PwTel.setColumns(10);

		JButton btn_IdSerch = new JButton("");
		btn_IdSerch.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn_IdSerch.addMouseListener(new MouseAdapter() {
			// 아이디 찾기
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tf_IdName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "이름 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_IdTel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요", "전화번호 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else {
					String message = tf_IdName.getText() + "," + tf_IdTel.getText();
					Object result = new ClientController().send(POST, FIND_ID, message);
					if (result instanceof String) {
						String resultId = (String) result;
						JOptionPane.showMessageDialog(null, "아이디는 " + resultId + " 입니다", "검색 결과",
								JOptionPane.INFORMATION_MESSAGE);
						
					} else if (result == null) {
						JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다", "검색 결과", JOptionPane.ERROR_MESSAGE);
					}
					tf_IdName.setText("");
					tf_IdTel.setText("");
				}
			}
		});
		btn_IdSerch.setBackground(Color.WHITE);
		btn_IdSerch.setIcon(new ImageIcon("gui_imgs/btn_findInfo_1.png"));
		btn_IdSerch.setBounds(310, 250, 116, 79);
		getContentPane().add(btn_IdSerch);

		JButton btn_PwSerch = new JButton("");
		btn_PwSerch.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn_PwSerch.addMouseListener(new MouseAdapter() {
			// 비밀번호 찾기
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tf_PwId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "아이디 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_PwTel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요", "전화번호 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else {
					String message = tf_PwId.getText() + "," + tf_PwTel.getText();
					Object result = new ClientController().send(POST, FIND_PW, message);
					if (result instanceof Boolean) {
						boolean resultPwd = (boolean) result;
						if (resultPwd) {
							String tempPwd = (String) JOptionPane.showInputDialog(null,
									"입력하신 정보가 존재합니다.\n변경하실 비밀번호를 입력해주세요", "비밀번호 변경", JOptionPane.INFORMATION_MESSAGE);
							if (tempPwd != null) {
								String modifyPwd = tf_PwId.getText() + "/" + tempPwd;
								Object resultModify = new ClientController().send(POST, MODIFY_PASSWORD, modifyPwd);
								if (resultModify instanceof Boolean) {
									boolean resultModifyPwd = (boolean) resultModify;
									if (resultModifyPwd) {
										JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.", "변경 결과",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(null, "비밀번호를 변경하지 못했습니다.", "변경 오류",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "비밀번호를 변경하지 못했습니다.", "변경 취소",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다", "검색 결과", JOptionPane.ERROR_MESSAGE);
						}
					}
					tf_PwId.setText("");
					tf_PwTel.setText("");
				}
			}
		});
		btn_PwSerch.setIcon(new ImageIcon("gui_imgs/btn_findInfo_1.png"));
		btn_PwSerch.setBounds(310, 423, 116, 79);
		getContentPane().add(btn_PwSerch);

		JButton btn_back = new JButton("뒤로가기");
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn_back.addMouseListener(new MouseAdapter() {
			// 로그인 메인메뉴로 이동
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new LoginView();
				dispose();
			}
		});
		btn_back.setBounds(387, 10, 95, 28);
		getContentPane().add(btn_back);

		setVisible(true);
	}


}
