/*
 * 응용어플리케이션에서 페이지 전환 방법을 학습해보자
 * */
package day1109.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center; //여기에 페이지들이 위치함!
	
	JButton[] btn = new JButton[4];
	String[] title = {"Home","게시판","로그인","회원가입"};
	JPanel[] pages = new JPanel[4];
	
	/*4개의 준비된 페이지*/
	Home home;
	Board board;
	Login login;
	Member member;
	
	public MainApp() {
		p_north = new JPanel();
		p_center = new JPanel();
		
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(title[i]);
			p_north.add(btn[i]);//북쪽 패널에 버튼 부착!
			btn[i].addActionListener(this);
		}
		add(p_north, BorderLayout.NORTH);
		add(p_center); //페이지 컨테이너를 센터에 부착
		
		//페이지 생성 
		home = new Home();
		board = new Board();
		login = new Login();
		member = new Member();
		
		pages[0] = home;
		pages[1] = board;
		pages[2] = login;
		pages[3] = member;
		//페이지 스타일 설정
		home.setPreferredSize(new Dimension(580, 480));
		btn[0].setBackground(Color.red);
		board.setPreferredSize(new Dimension(580, 480));
		btn[1].setBackground(Color.yellow);
		login.setPreferredSize(new Dimension(580, 480));
		btn[2].setBackground(Color.green);
		member.setPreferredSize(new Dimension(580, 480));
		btn[3].setBackground(Color.blue);
		
		//센터영역에 4개의 준비된 페이지를 붙여넣자!!
		p_center.add(home);
		p_center.add(board);
		p_center.add(login);
		p_center.add(member);
		
		setVisible(true);
		pack();//내용물의 크기만큼 수축!!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn[0]) {
			setPage(0);
		}else if(obj == btn[1]) {
			setPage(1);
		}else if(obj == btn[2]) {
			setPage(2);
		}else if(obj == btn[3]) {
			setPage(3);
		}
	}
	public void setPage(int index) {
		for(int i=0; i<pages.length; i++) {
			if(index == i)
				pages[i].setVisible(true);
			else
				pages[i].setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new MainApp();
	}
}