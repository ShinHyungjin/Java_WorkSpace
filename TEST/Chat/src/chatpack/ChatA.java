package chatpack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChatA extends JFrame{
	JPanel p_chat;
	JLabel la_text;
	ChatingText text;
	JScrollPane scroll;
	JPanel jp;
	JButton jb;
	JTextField jt;
	ChatB chb;
	JTextField tx;
	
	public ChatA() {
		super();
		p_chat = new JPanel();
		p_chat.setBackground(Color.yellow);
		p_chat.setLayout(new GridLayout(10,1));
		p_chat.setPreferredSize(new Dimension(120,100));
		
		jt = new JTextField(15);
		jt.setBackground(Color.cyan);
		jt.setForeground(Color.black);
		jt.setPreferredSize(new Dimension(285,30));
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		jb = new JButton("전송하기");
		jb.setBackground(Color.BLACK);
		jb.setForeground(Color.white);
		
		tx = new JTextField(10);
		
		scroll = new JScrollPane(p_chat);
		
		jp.add(jt);
		jp.add(jb);

		add(scroll);
		add(jp, BorderLayout.SOUTH);
		setBounds(200, 150, 500, 400);
		
		jt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==10) {
					send();
				}
			}
		});
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		
		setTitle("A");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void send() {
		text = new ChatingText(jt.getText(), this);
		la_text = text.test();
		p_chat.add(la_text);
		System.out.println(la_text.getText());
		jt.setText("");
		p_chat.updateUI();
	}
	
	public static void main(String[] args) {
		new ChatA();
	}
}
