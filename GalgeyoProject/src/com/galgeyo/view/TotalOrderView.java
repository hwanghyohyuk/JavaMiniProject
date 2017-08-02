package com.galgeyo.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.galgeyo.controller.SessionController;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Session;


//주문 통계
public class TotalOrderView extends JFrame{
	
	private Session session = new Session();
	
	
	public TotalOrderView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				session.setSession(new SessionController().sessionLoad());
				Manager manager = (Manager) session.getSession();
			}
		});

		this.setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
	}

}
