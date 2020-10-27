package day1027.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	JButton bt;
	public SwingTest() {
		bt = new JButton("버튼");
		setLayout(new FlowLayout());
		add(bt);
		setVisible(true);
		setSize(300,400);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public static void main(String[] args) {
		new SwingTest();
		

	}

}
