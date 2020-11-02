package day1102.icon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IconApp extends JFrame{
	JButton bt;
	ImageIcon icon;
	URL url= this.getClass().getClassLoader().getResource("res/youtube.png");
	public IconApp() {
		icon = new ImageIcon(url);
		Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		icon.setImage(img);
		bt = new JButton("나 버튼", icon);
		bt.setPreferredSize(new Dimension(200, 200));
		setLayout(new FlowLayout());
		add(bt);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new IconApp();

	}
}
