package com.galgeyo.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.galgeyo.controller.SessionController;
import com.galgeyo.controller.UserInfoEditController;
import com.galgeyo.server.ClientController;
import com.galgeyo.server.Protocol;
import com.galgeyo.vo.User;
import com.galgeyo.vo.Session;
import com.galgeyo.vo.User;

//개인정보수정
public class UserInfoEditView extends JFrame implements Protocol{

	private JPasswordField tf_confirmPw;
	private JTextField tf_name;
	private JTextField tf_tel;
	private JPasswordField tf_modifyPw;
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
		
		JLabel title_text = new JLabel("개인 정보 수정");
		title_text.setIcon(null);
		title_text.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		title_text.setBounds(86, 10, 302, 60);
		panel.add(title_text);
		
		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("gui_imgs/icon_userInfoEdit_1.png"));
		title_icon.setBounds(12, 10, 62, 60);
		panel.add(title_icon);

		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 90, 794, 482);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Img1 = new JLabel("");
		lbl_Img1.setBounds(60, 44, 49, 47);
		panel_1.add(lbl_Img1);
		lbl_Img1.setIcon(new ImageIcon("gui_imgs/icon_userInfoEdit_2.png"));
		
		JLabel lbl_info = new JLabel("수정할 정보를 입력해주세요.");
		lbl_info.setBounds(136, 35, 278, 63);
		lbl_info.setForeground(new Color(42, 66, 80));
		lbl_info.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(lbl_info);
		
		JLabel lbl_name = new JLabel("이름");
		lbl_name.setBounds(80, 156, 81, 29);
		lbl_name.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(lbl_name);
		
		JLabel lbl_tel = new JLabel("전화번호");
		lbl_tel.setBounds(80, 227, 81, 29);
		lbl_tel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(lbl_tel);
		
		JLabel lbl_EditPwd = new JLabel("수정할 비밀번호");
		lbl_EditPwd.setBounds(80, 301, 128, 29);
		lbl_EditPwd.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(lbl_EditPwd);
		
		JLabel lbl_confirmId = new JLabel("비밀번호 확인");
		lbl_confirmId.setBounds(80, 352, 128, 42);
		lbl_confirmId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(lbl_confirmId);
		
		tf_name = new JTextField();
		tf_name.setBounds(235, 156, 195, 25);
		tf_name.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(tf_name);
		
		tf_name.setColumns(10);
		tf_tel = new JTextField();
		tf_tel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_tel.setBounds(235, 228, 195, 26);
		panel_1.add(tf_tel);
		
		tf_tel.setColumns(10);
		tf_modifyPw = new JPasswordField();
		tf_modifyPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		tf_modifyPw.setBounds(235, 303, 195, 24);
		panel_1.add(tf_modifyPw);
		
		tf_modifyPw.setColumns(10);
		btn_back = new JButton("뒤로가기");
		btn_back.setBounds(682, 0, 100, 28);
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserMainView();
				dispose();
			}
		});
		
		JLabel lbl_logo = new JLabel("");
		lbl_logo.setIcon(new ImageIcon("gui_imgs/logo_galgeyo_2.png"));
		lbl_logo.setBounds(666, 3, 99, 73);
		panel.add(lbl_logo);
		
		btn_back.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tf_confirmPw = new JPasswordField();
		tf_confirmPw.setBounds(235, 359, 195, 26);
		tf_confirmPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_1.add(tf_confirmPw);
		
		tf_confirmPw.setColumns(10);
		btn_modify = new JButton("");
		btn_modify.setBounds(650, 400, 107, 51);
		btn_modify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Session clone = new Session();
				User manager = (User) session.getSession();
				clone.setSession(manager);
				User cloneUser =  (User) clone.getSession();
				if(tf_name.getText().equals("")){
					JOptionPane.showMessageDialog(null,"이름를 입력해주세요.","개인정보 수정 오류",JOptionPane.WARNING_MESSAGE);
				}else if(tf_tel.getText().equals("")){
					JOptionPane.showMessageDialog(null,"전화번호를 입력해주세요.","개인정보 수정 오류",JOptionPane.WARNING_MESSAGE);
				}else{
					if(!tf_name.getText().equals(manager.getName())){//변경사항확인
						cloneUser.setName(tf_name.getText());
					}
					if(!tf_tel.getText().equals(manager.getTel())){
						cloneUser.setTel(tf_tel.getText());
					}					
					if(!tf_modifyPw.getText().equals("")){//비밀번호 수정하면
						if(tf_confirmPw.getText().equals("")){//비밀번호 확인이 빈칸이면
							JOptionPane.showMessageDialog(null,"수정할 비밀번호와 같은 비밀번호를 입력해주세요","개인정보 수정 오류",JOptionPane.WARNING_MESSAGE);
						}else{//비밀번호 확인이 빈칸이 아니면
							if(tf_modifyPw.getText().equals(tf_confirmPw.getText())){//수정과 확인이 같다면
								cloneUser.setPwd(tf_modifyPw.getText());
								submit(cloneUser);
							}else{//수정과 확인이 다르다면
								JOptionPane.showMessageDialog(null,"수정할 비밀번호와 같은 비밀번호를 입력해주세요","개인정보 수정 오류",JOptionPane.WARNING_MESSAGE);
							}
						}
					}else{
						submit(cloneUser);
					}					
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
	
	private void submit(User cloneUser){
		User message = cloneUser;
		Object result = new ClientController().send(POST, EDIT_USER_INFO, message);
		if(result instanceof Boolean){
			boolean check = (boolean)result;
			if(check){
				JOptionPane.showMessageDialog(null,"개인정보가 성공적으로 수정되었습니다.","개인정보 수정 성공",JOptionPane.INFORMATION_MESSAGE);
				new SessionController().sessionSave(cloneUser);
				new UserMainView();
				dispose();
			}else{
				JOptionPane.showMessageDialog(null,"개인정보를 업로드하는데 실패하였습니다.","개인정보 수정 실패",JOptionPane.ERROR_MESSAGE);
				new UserMainView();
				dispose();
			}
		}
	}
}
