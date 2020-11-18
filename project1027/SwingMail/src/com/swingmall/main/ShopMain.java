package com.swingmall.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.board.QnA;
import com.swingmall.home.Home;
import com.swingmall.member.Login;
import com.swingmall.member.MyPage;
import com.swingmall.product.Product;
import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame{
	public static final int WIDTH=1200;
	public static final int HEIGHT=900;
	
	public static final int HOME=0;
	public static final int PRODUCT=1;
	public static final int QNA=2;
	public static final int MYPAGE=3;
	public static final int LOGIN=4;
	
	JPanel user_container; // 관리자,사용자 화면 구분
	JPanel p_navi; // 메인화면의 헤더
	JLabel la_footer; // 하단의 카피라이트
	String [] navi_title = {"Home", "Product", "QnA", "MyPage", "Login"};
	JButton [] navi = new JButton[navi_title.length];
	Page[] page = new Page[navi_title.length];
	
	DBManager dbManager;
	Connection con;
	
	
	public ShopMain() {
		user_container = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved",SwingConstants.CENTER);
		p_navi = new JPanel();
		
		user_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-50));
		user_container.setBackground(Color.white);
		la_footer.setFont(new Font("Arial Black", Font.BOLD,19));
		
		p_navi.setPreferredSize(new Dimension(WIDTH, HEIGHT-850));
		p_navi.setLayout(new FlowLayout());
		
		for(int i=0; i<5; i++) {
			navi[i] = new JButton(navi_title[i]);
			navi[i].setPreferredSize(new Dimension(200,45));
			p_navi.add(navi[i]);
		}
		page[HOME] = new Home(this);
		page[PRODUCT] = new Product(this);
		page[QNA] = new QnA(this);
		page[MYPAGE] = new MyPage(this);
		page[LOGIN] = new Login(this);
		
		dbManager = new DBManager();
		con = dbManager.connect();
		
		if(con==null) {
			JOptionPane.showMessageDialog(this, "DB접속 실패");
			System.exit(0);
		}else {
			JOptionPane.showMessageDialog(this, "DB접속 성공");
			this.setTitle("Welcome to SwingShop!");
		}
		user_container.setPreferredSize(new Dimension(WIDTH,HEIGHT-50));
		la_footer.setPreferredSize(new Dimension(WIDTH,HEIGHT-850));
		
		
		user_container.add(p_navi);
		for(int i=0; i<5; i++) {
			user_container.add(page[i]);
		}
		
		add(user_container);
		add(la_footer, BorderLayout.SOUTH);
		
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbManager.disconnect(con);
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new ShopMain();
	}
}
