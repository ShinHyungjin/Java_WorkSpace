package day1028.graphic.line;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineMaker extends JFrame{
	XCanvas can;
	JLabel x1,x2,y1,y2;
	JTextField tx1,tx2,ty1,ty2;
	JButton ok;
	JPanel jp;
	public LineMaker() {
		can = new XCanvas();
		can.setLineMaker(this);
		can.setBackground(Color.cyan);
		jp = new JPanel();
		jp.setLayout(new FlowLayout());
		x1 = new JLabel("x1");
		x2 = new JLabel("x2");
		y1 = new JLabel("y1");
		y2 = new JLabel("y2");
		tx1 = new JTextField("100",10);
		tx2 = new JTextField("100",10);
		ty1 = new JTextField("200",10);
		ty2 = new JTextField("200",10);
		ok = new JButton("OK");
		
		jp.setSize(new Dimension(700, 120));
		
		jp.add(x1);
		jp.add(tx1);
		jp.add(x2);
		jp.add(tx2);
		jp.add(y1);
		jp.add(ty1);
		jp.add(y2);
		jp.add(ty2);
		jp.add(ok);
		jp.setBackground(Color.yellow);
		
		add(jp, BorderLayout.NORTH);
		add(can);
		
		ok.addActionListener(new MyListener(can));
		
		
		setSize(700,600);
		setVisible(true);
		
	}
	public static void main(String [] args) {
		new LineMaker();
	}
}
