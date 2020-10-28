package day1028.graphic.img;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class PaintTest extends JFrame{
	MyCanvas can;
	public PaintTest() {
		can = new MyCanvas();
		add(can);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new PaintTest();
	}
}
