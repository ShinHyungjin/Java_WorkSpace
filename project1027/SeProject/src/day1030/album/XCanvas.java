package day1030.album;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class XCanvas extends Canvas{
	private Image img;
	private Toolkit kit;
	private String src;
	public XCanvas(String src) {
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(src);
		img = img.getScaledInstance(660, 400, Image.SCALE_SMOOTH);
		setPreferredSize(new Dimension(660, 400));
		setBackground(Color.DARK_GRAY);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0,0 , this);
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		img = kit.getImage(src);
		img = img.getScaledInstance(660, 400, Image.SCALE_SMOOTH);
		this.src = src;
	}

}
