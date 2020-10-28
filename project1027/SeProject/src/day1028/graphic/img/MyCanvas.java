package day1028.graphic.img;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas{
	Toolkit kit=null;
	Image img;
	public MyCanvas() {
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage("D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/aa.jpg");
	}
	public void paint(Graphics g) {
		g.drawLine(50,50,200,200);
		g.drawOval(50,50,200,200);
		g.drawRect(50,50,200,200);
		
		g.setColor(Color.RED);
		g.fill3DRect(100, 100, 50, 50, true);
		g.setColor(Color.BLUE);
		g.drawString("그린글씨",100,100);
		
		g.drawImage(img, 150, 150, this);
		
	}
}
