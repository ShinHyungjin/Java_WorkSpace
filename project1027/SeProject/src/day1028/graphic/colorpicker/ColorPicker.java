package day1028.graphic.colorpicker;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class ColorPicker extends JFrame{
	MyPanel p;
	MyCanvas can;
	public ColorPicker() {
		p = new MyPanel();
		can = new MyCanvas();
		can.setBackground(Color.white);
		
		add(p, BorderLayout.NORTH);
		add(can);
		
		setSize(770,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ColorPicker();
	}
}
