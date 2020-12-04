package chatpack;

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

public class ChatB extends JFrame implements KeyListener, ActionListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel jp;
	JButton jb;
	JTextField jt;
	ChatA cha;
	public ChatB() {
		super("�궃 遺�紐�");
		jt = new JTextField(15);
		jt.setBackground(Color.cyan);
		jt.setForeground(Color.WHITE);
		jt.setPreferredSize(new Dimension(285,30));
		jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jb = new JButton("�쟾�넚");
		jb.setBackground(Color.BLACK);
		jb.setForeground(Color.white);
		
		area = new JTextArea();
		scroll = new JScrollPane(area);

		add(scroll);
		
		area.setBackground(Color.yellow);//area諛곌꼍�깋 諛붽씀湲�
		area.setFont(new Font("�룍��泥�",Font.BOLD|Font.ITALIC, 20));
		
		jp.add(jt);
		jp.add(jb);
		
		add(jp, BorderLayout.SOUTH);
		//setSize(400,600);
		setBounds(800, 150, 400, 400);
		
		jt.addKeyListener(this);
		jb.addActionListener(this);
		
		setTitle("蹂대궡�뒗�씠");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jb) {
			send();
		}
	}
	public void send() {
		area.append(jt.getText()+"\n");
		//area.setText(area.getText()+jt.getText()+"\n");
		cha.area.append(jt.getText()+"\n");
		jt.setText("");
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
	public void setCha(ChatA cha) {
		this.cha = cha;
	}
}
