package com.galgeyo.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.galgeyo.vo.Manager;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//관리자 메인화면
public class ManagerMainView extends JFrame {
	
	public ManagerMainView() {
		setBounds(200, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 57, 43));
		panel.setBounds(0, 0, 784, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title_text = new JLabel("마이페이지");
		title_text.setIcon(null);
		title_text.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		title_text.setBounds(86, 20, 302, 40);
		panel.add(title_text);
		
		JLabel title_icon = new JLabel("");
		title_icon.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\icon_user_1.png"));
		title_icon.setBounds(32, 16, 50, 50);
		panel.add(title_icon);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\user1\\Documents\\GitHub\\JavaMiniProject\\GalgeyoProject\\gui_imgs\\logo_galgeyo_2.png"));
		logo.setBounds(666, 3, 99, 73);
		panel.add(logo);
		
		JButton button = new JButton("로그아웃");
		button.setForeground(new Color(52, 73, 94));
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		button.setBounds(679, 90, 92, 30);
		getContentPane().add(button);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new ManagerMainView();
	}
}
