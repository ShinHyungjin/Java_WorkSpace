package day1029.graphic.image;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class ThumbCanvas extends Canvas implements MouseListener{
	Toolkit kit;
	Image img;
	DetailPanel p_center;
	JLabel l_north;
	String dir;
	public ThumbCanvas(String path, DetailPanel p_center, JLabel l_north, String dir) {
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(path);
		this.setPreferredSize(new Dimension(140, 100));
		this.p_center = p_center;
		this.l_north = l_north;
		this.dir = dir;
		
		this.addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		p_center.setImg(img);
		p_center.repaint();
		l_north.setText(dir);
		System.out.println(dir);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
