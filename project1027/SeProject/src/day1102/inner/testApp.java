package day1102.inner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.sun.glass.events.WindowEvent;

public class testApp extends JFrame{
	Canvas can;
	JButton bt;
	JTextField t;
	
	public testApp() {
		add(can = new Canvas() {
			public void paint(Graphics g) {
				g.drawLine(0, 0, 100, 100);
			}
		});

		add(bt = new JButton() {
			public void paint(Graphics g) {
				g.setColor(Color.red);
				g.fillRect(0,0,100,40);
			}
		});
		
		add(t = new JTextField(20));
		t.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				System.out.println("누름?");
			}
		});
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼누름?");
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		can.setPreferredSize(new Dimension(200, 200));
		t.setPreferredSize(new Dimension(100, 100));
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new testApp();
	}
}
