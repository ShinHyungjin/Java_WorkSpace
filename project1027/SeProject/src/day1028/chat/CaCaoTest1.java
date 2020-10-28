package day1028.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//GUI 즉 보여지는 객체들은 거의 일반 클래스...
public class CaCaoTest1 extends JFrame implements KeyListener, ActionListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel jp;
	JButton jb,jb2;
	JTextField jt;
	CaCaoTest2 ch2;
	
	public CaCaoTest1() {
		//super("난 부모");
		jt = new JTextField(15);
		jt.setBackground(Color.cyan);
		jt.setForeground(Color.WHITE);
		jt.setPreferredSize(new Dimension(285,30));
		jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jb = new JButton("전송");
		jb.setBackground(Color.BLACK);
		jb.setForeground(Color.white);
		jb2 = new JButton("오픈");
		jb2.setBackground(Color.BLACK);
		jb2.setForeground(Color.white);
		
		area = new JTextArea();
		scroll = new JScrollPane(area);

		add(scroll);
		
		area.setBackground(Color.yellow);//area배경색 바꾸기
		area.setFont(new Font("돋움체",Font.BOLD|Font.ITALIC, 20));
		
		jp.add(jt);
		jp.add(jb);
		jp.add(jb2);
		
		add(jp, BorderLayout.SOUTH);
		setSize(400,600);
		
		jt.addKeyListener(this);
		jb.addActionListener(this);
		jb2.addActionListener(this);
		
		setTitle("보내는이");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jb) {
			send();
		}
		else if(obj == jb2) {
			open();
		}
	}
	public void send() {
		area.append(jt.getText()+"\n");
		ch2.area.append(jt.getText()+"\n");
		//area.setText(area.getText()+jt.getText()+"\n");
		jt.setText("");
	}
	public void open() {
		ch2 = new CaCaoTest2(this);
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==10) {
			send();
		}
	}
	public static void main(String[] args) {
		new CaCaoTest1();
	}
}
