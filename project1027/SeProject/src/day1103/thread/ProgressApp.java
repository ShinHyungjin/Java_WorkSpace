package day1103.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class ProgressApp extends JFrame{
	JLabel la1,la2,la3;
	JProgressBar bar1,bar2,bar3;
	BarThread t1,t2,t3;
	public ProgressApp() {
		la1 = new JLabel("0", SwingConstants.CENTER);
		la1.setPreferredSize(new Dimension(500, 150));
		la1.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 80));
		
		la2 = new JLabel("0", SwingConstants.CENTER);
		la2.setPreferredSize(new Dimension(500, 150));
		la2.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 80));
		
		la3 = new JLabel("0", SwingConstants.CENTER);
		la3.setPreferredSize(new Dimension(500, 150));
		la3.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 80));
		
		bar1 = new JProgressBar();
		bar1.setPreferredSize(new Dimension(500, 50));
		
		bar2 = new JProgressBar();
		bar2.setPreferredSize(new Dimension(500, 50));
		
		bar3 = new JProgressBar();
		bar3.setPreferredSize(new Dimension(500, 50));
		
		add(la1);
		add(bar1);
		add(la2);
		add(bar2);
		add(la3);
		add(bar3);
		
		t1 = new BarThread(la1, bar1, 70);
		t2 = new BarThread(la2, bar2, 110);
		t3 = new BarThread(la3, bar3, 140);
		
		t1.start();
		t2.start();
		t3.start();
		
		setLayout(new FlowLayout());
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ProgressApp();
	}
}
