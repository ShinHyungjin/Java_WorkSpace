package day1102.io;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyClassPath extends JFrame{
	JTextField t;
	BufferedReader br;
	BufferedWriter bw;
	URL url; 
	public MyClassPath() {
		url = = this.getClass().getClassLoader().getResource("res/test.txt");
		add(t = new JTextField(20));
		t.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					br = new BufferedReader(new FileReader(url));
				}
			}
		});
		
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new MyClassPath();
	}

}
