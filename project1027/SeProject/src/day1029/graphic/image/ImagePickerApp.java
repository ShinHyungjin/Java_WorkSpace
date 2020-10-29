package day1029.graphic.image;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePickerApp extends JFrame implements ActionListener{
	JPanel p_north, p_west, p_south;
	JLabel l_north;
	JButton b_prev, b_next;
	DetailPanel p_center;
	String dir="D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/";
	String [] path = {
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
	ThumbCanvas [] thumb = new ThumbCanvas[path.length];
	public ImagePickerApp() {
		l_north = new JLabel("");
		
		b_prev = new JButton("이전");
		b_next = new JButton("다음");
		
		p_west = new JPanel();
		p_west.setLayout(new FlowLayout());
		p_west.setPreferredSize(new Dimension(130, 660));
		
		p_north = new JPanel();
		p_north.setLayout(new FlowLayout());
		p_north.setPreferredSize(new Dimension(500,100));
		p_north.add(l_north);
		
		p_south = new JPanel();
		p_south.setLayout(new FlowLayout());
		p_south.setPreferredSize(new Dimension(500,100));
		p_south.add(b_prev);
		p_south.add(b_next);
		
		p_center = new DetailPanel();
		
		for(int i=0; i<thumb.length; i++) {
			thumb[i] = new ThumbCanvas(dir+path[i], p_center, l_north, path[i]);
			p_west.add(thumb[i]);
		}
		
		add(p_west, BorderLayout.WEST);
		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.SOUTH);
		add(p_center);
		
		b_prev.addActionListener(this);
		b_next.addActionListener(this);
		
		setSize(800,900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b_prev)
			prev();
		else if(obj == b_next)
			next();
	}
	public void prev() {
		
	}
	public void next() {
		
	}
	
	public static void main(String [] args) {
		new ImagePickerApp();
	}
}
