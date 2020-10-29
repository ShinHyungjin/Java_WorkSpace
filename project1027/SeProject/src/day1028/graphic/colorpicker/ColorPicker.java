package day1028.graphic.colorpicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPicker extends JFrame{
	MyPanel p;
	JPanel jp;
	public ColorPicker() {
		p = new MyPanel();
		jp = new JPanel();
		jp.setBackground(Color.white);
		
		jp.setPreferredSize(new Dimension(770, 390));
		add(p, BorderLayout.NORTH);
		add(jp);
		
		new MyPanel(jp);
		
		setSize(770,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ColorPicker();
		
	}
}
