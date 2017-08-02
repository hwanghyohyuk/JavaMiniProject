package com.galgeyo.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//아이디, 패스워드 찾기
public class FindInfoView extends JFrame {
	private JTextField tf_IdName;
	private JTextField tf_IdTel;
	private JTextField tf_PwId;
	private JTextField tf_PwTel;
	
	
	public FindInfoView() {
		getContentPane().setBackground(Color.WHITE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lbl_FindInfoImg = new JLabel("");
		lbl_FindInfoImg.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_login_2.png"));
		lbl_FindInfoImg.setBounds(72, 69, 41, 44);
		getContentPane().add(lbl_FindInfoImg);
		
		JLabel lbl_FindInfo = new JLabel("ID/PW 찾기");
		lbl_FindInfo.setBounds(125, 85, 80, 23);
		getContentPane().add(lbl_FindInfo);
		
		JLabel lbl_FindInfoDec = new JLabel("회원가입 시 입력한 정보로 아이디와 비밀번호를 검색합니다.");
		lbl_FindInfoDec.setBounds(82, 123, 354, 15);
		getContentPane().add(lbl_FindInfoDec);
		
		JLabel lbl_FindIdImg = new JLabel("");
		lbl_FindIdImg.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_findInfo_2.png"));
		lbl_FindIdImg.setBounds(72, 218, 34, 34);
		getContentPane().add(lbl_FindIdImg);
		
		JLabel lbl_ = new JLabel("아이디 찾기");
		lbl_.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lbl_.setBounds(118, 218, 89, 34);
		getContentPane().add(lbl_);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(72, 276, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(72, 307, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_findInfo_2.png"));
		lblNewLabel_7.setBounds(72, 364, 34, 34);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("비밀번호 찾기");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(118, 364, 89, 34);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(72, 422, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(72, 453, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		tf_IdName = new JTextField();
		tf_IdName.setBounds(141, 270, 116, 29);
		getContentPane().add(tf_IdName);
		tf_IdName.setColumns(10);
		
		tf_IdTel = new JTextField();
		tf_IdTel.setBounds(141, 301, 116, 29);
		getContentPane().add(tf_IdTel);
		tf_IdTel.setColumns(10);
		
		tf_PwId = new JTextField();
		tf_PwId.setBounds(141, 420, 116, 21);
		getContentPane().add(tf_PwId);
		tf_PwId.setColumns(10);
		
		tf_PwTel = new JTextField();
		tf_PwTel.setBounds(141, 451, 116, 21);
		getContentPane().add(tf_PwTel);
		tf_PwTel.setColumns(10);
		
		JButton btn_IdSerch = new JButton("");
		btn_IdSerch.addMouseListener(new MouseAdapter() {
			//아이디 찾기
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(tf_IdName.getText().equals("")) && !(tf_IdTel.getText().equals(""))){
					JOptionPane.showMessageDialog(null, "아이디를 확인하였습니다", "아이디 검색", JOptionPane.WARNING_MESSAGE);
					new LoginView();
					dispose();
			}else if(tf_IdName.getText().equals("")){
				 JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "이름 입력", JOptionPane.WARNING_MESSAGE);
			}else if(tf_IdTel.getText().equals("")){
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요", "전화번호 입력", JOptionPane.WARNING_MESSAGE);
				
			}
	
				
			
			}
		});
		btn_IdSerch.setBackground(Color.WHITE);
		btn_IdSerch.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_findInfo_1.png"));
		btn_IdSerch.setBounds(269, 259, 116, 79);
		getContentPane().add(btn_IdSerch);
		
		JButton btn_PwSerch = new JButton("");
		btn_PwSerch.addMouseListener(new MouseAdapter() {
			//비밀번호 찾기
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(tf_PwId.getText().equals("")) && !(tf_PwTel.getText().equals(""))){
					JOptionPane.showMessageDialog(null,"비밀번호를 확인하였습니다", "비밀번호 검색", JOptionPane.WARNING_MESSAGE);
					new LoginView();
					dispose();
					
			}else if(tf_PwId.getText().equals("")){
				 JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "이름 입력", JOptionPane.WARNING_MESSAGE);
			}else if(tf_PwTel.getText().equals("")){
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요", "전화번호 입력", JOptionPane.WARNING_MESSAGE);
				
			}
				
			}
		});
		btn_PwSerch.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\btn_findInfo_1.png"));
		btn_PwSerch.setBounds(269, 407, 116, 79);
		getContentPane().add(btn_PwSerch);
		
		JButton btn_back = new JButton("뒤로가기");
		btn_back.addMouseListener(new MouseAdapter() {
			//로그인 메인메뉴로 이동
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new LoginView();
				dispose();
			}
		});
		btn_back.setBounds(387, 10, 95, 23);
		getContentPane().add(btn_back);
	
		setVisible(true);
	}
	public static void main(String[] args) {
		new FindInfoView();
	}
	
}
