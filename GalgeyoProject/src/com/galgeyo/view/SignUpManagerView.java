package com.galgeyo.view;

import javax.swing.*;

import com.galgeyo.server.ClientController;
import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.User;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//관리자 회원가입
public class SignUpManagerView extends JFrame implements Protocol {

	private JTextField tf_id;
	private JPasswordField tf_pwd;
	private JTextField tf_storeName;
	private JTextField tf_ownNo;
	private JTextField tf_addr;
	private JTextField tf_tel;
	private JButton btn_confirmId;

	private boolean confirmId = false;

	public SignUpManagerView() {
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		tf_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				confirmId=false;
				btn_confirmId.setEnabled(!confirmId);
			}
		});
		tf_id.setBounds(160, 179, 206, 28);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);

		tf_pwd = new JPasswordField();
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

		btn_confirmId = new JButton("");
		btn_confirmId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 입력한 데이터를 서버로 전송
					if (tf_id.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "아이디 입력 오류", JOptionPane.WARNING_MESSAGE);
					} else {
						// 서버의 데이터 파일에서 아이디 찾음
						String message = tf_id.getText();
						Object result = new ClientController().send(POST, REG_ID_CHECK, message);
						if(result instanceof Boolean){
							boolean check = (boolean)result;
							if(check){// 아이디가 있으면
								JOptionPane.showMessageDialog(null, "입력하신 아이디가 존재합니다.", "아이디 중복", JOptionPane.WARNING_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디입니다.", "아이디 사용 가능", JOptionPane.INFORMATION_MESSAGE);
								confirmId = true;
								btn_confirmId.setEnabled(!confirmId);
							}
						}
					}
			}
		});

		JComboBox cb_type = new JComboBox();
		cb_type.setModel(new DefaultComboBoxModel(new String[] { "한식", "중식", "양식", "일식" }));
		cb_type.setBounds(160, 424, 206, 28);
		getContentPane().add(cb_type);
		btn_confirmId.setIcon(new ImageIcon("gui_imgs/btn_signUp_3.png"));
		btn_confirmId.setBounds(378, 179, 80, 28);
		getContentPane().add(btn_confirmId);

		JButton btn_submit = new JButton("");
		btn_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 매장 관리자 회원가입 제출
				if (tf_id.getText().equals("")) {// 아이디빈칸확인
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "아이디 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (!confirmId) {// 아이디 중복검사 확인
					JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요", "아이디 중복확인 오류",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tf_pwd.getText().equals("")) {// 비밀번호 빈칸확인
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "비밀번호 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_storeName.getText().equals("")) {// 매장 이름 빈칸확인
					JOptionPane.showMessageDialog(null, "매장 이름을 입력해주세요", "매장 이름 입력 오류",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tf_tel.getText().equals("")) {// 사업자번호 빈칸확인
					JOptionPane.showMessageDialog(null, "사업자 번호를 입력해주세요", "사업자 번호 입력 오류",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tf_tel.getText().equals("")) {// 주소 빈칸확인
					JOptionPane.showMessageDialog(null, "주소를 입력해주세요", "주소 입력 오류", JOptionPane.WARNING_MESSAGE);
				} else if (tf_tel.getText().equals("")) {// 전화번호 빈칸확인
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요", "전화번호 입력 오류", JOptionPane.WARNING_MESSAGE);
				}else{
					Manager message = new Manager(false, tf_id.getText(), tf_pwd.getText(), tf_storeName.getText(),tf_tel.getText(),tf_addr.getText(), tf_ownNo.getText(),(String) cb_type.getSelectedItem());
					Object result = new ClientController().send(POST, REG_USER, message);
					if(result instanceof Boolean){
						boolean check = (boolean)result;
						if (check) {
							JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "사용자 회원가입 완료", JOptionPane.INFORMATION_MESSAGE);
							new LoginView();
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "회원가입이 실패하였습니다.", "사용자 회원가입 오류", JOptionPane.INFORMATION_MESSAGE);
						}
					}		
				}
			}
		});
		btn_submit.setIcon(new ImageIcon("gui_imgs/btn_signUp_4.png"));
		btn_submit.setBounds(174, 476, 151, 64);
		getContentPane().add(btn_submit);

		JButton btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 회원가입 선택 화면으로 이동
				new SignUpView();
				dispose();
			}
		});
		btn_back.setBounds(382, 10, 100, 25);
		getContentPane().add(btn_back);

		this.setVisible(true);
	}
}

