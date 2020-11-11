package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.image.ImageUtil;
import day1111.member.Login;
import day1111.member.RegistForm;

public class BoardApp extends JFrame{
	JPanel p_north, p_center;
	JButton bt_board, bt_regist, bt_login;
	
	JPanel [] pages = new JPanel[5];
	
	public static final int BOARDLIST=0;
	public static final int BOARDWRITE=1;
	public static final int BOARDETAIL=2;
	public static final int MEMBER_REGIST=3;
	public static final int MEMBER_LOGIN=4;
	
	public BoardApp() {
		pages[0] = new BoardList(this); // 게시판 목록 페이지
		pages[1] = new BoardWrite(this); // 게시판 글쓰기 페이지
		pages[2] = new BoardDetail(this); // 게시판 글 상세보기 페이지
		pages[3] = new RegistForm(this); // 회원가입 페이지
		pages[4] = new Login(this); // 로그인 페이지
		
		p_north = new JPanel();
		p_center = new JPanel();
		bt_board = new JButton(ImageUtil.getIcon(this.getClass(), "res/board.png", 100, 45));
		bt_regist = new JButton(ImageUtil.getIcon(this.getClass(), "res/regist.png", 100, 45));
		bt_login = new JButton(ImageUtil.getIcon(this.getClass(), "res/login.png", 100, 45));
		
		bt_board.setPreferredSize(new Dimension(100, 45));
		bt_regist.setPreferredSize(new Dimension(100, 45));
		bt_login.setPreferredSize(new Dimension(100, 45));
		
		p_north.add(bt_board);
		p_north.add(bt_regist);
		p_north.add(bt_login);
		
		p_center.add(pages[0]);
		p_center.add(pages[1]);
		p_center.add(pages[2]);
		p_center.add(pages[3]);
		p_center.add(pages[4]);
		
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Lambda 표현식 : 함수형 프로그램 표현식(JS에선 클로저라고 부름)
		//이벤트 구현시, 재정의할 메서드가 단 1개인 경우, 내부 익명 클래스로
		//크게 제작하기 보다는, 단순하게 표현하는 람다표기법 이용
		//actionperpormd를 익명 함수로 정의한 것과 같은표기
		bt_board.addActionListener((e)-> {
			setPage(BOARDLIST);
		});
		bt_regist.addActionListener((e)-> {
			setPage(MEMBER_REGIST);
		});
		bt_login.addActionListener((e)-> {
			setPage(MEMBER_LOGIN);
		});
		
	}
	public void setPage(int showIndex) {
		for(int i=0; i<pages.length; i++) {
			if(i == showIndex) {
				pages[i].setVisible(true);
			} else {
				pages[i].setVisible(false);
			}
		}
	}
	public static void main(String[] args) {
		new BoardApp();
	}
}
