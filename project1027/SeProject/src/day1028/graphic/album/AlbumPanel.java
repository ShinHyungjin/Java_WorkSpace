package day1028.graphic.album;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class AlbumPanel extends JPanel{
	public int n=0;
	String dir = "D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/";
	String [] src = {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",
			"bm.jpg",
			"et.jpg",
			"kg.jpg",
			"mx.jpg",
			"pk.jpg",
			"ub.jpg",
			"ya.jpg"
	};
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image [] img = new Image[10];
	public AlbumPanel() {
		for(int i=0; i<img.length; i++) {
			img[i] = kit.getImage(dir+src[i]);
			img[i] = img[i].getScaledInstance(500, 400, Image.SCALE_SMOOTH);
		}
	}
	public void paint(Graphics g) {
		g.drawImage(img[n],0,0,this);
	}
}
