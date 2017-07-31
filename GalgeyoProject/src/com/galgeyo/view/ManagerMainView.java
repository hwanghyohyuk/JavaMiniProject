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

//관리자 메인화면
public class ManagerMainView extends JFrame {
	
	public ManagerMainView() {
		setBounds(200, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(0, 0, 784, 60);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("마이페이지");
		lblNewLabel.setIcon(new ImageIcon(ManagerMainView.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 360, 40);
		panel.add(lblNewLabel);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new ManagerMainView();
	}
}
