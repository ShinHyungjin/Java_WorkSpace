package day1030.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GalleryApp extends JFrame implements ActionListener{
	static int n=0;
	JLabel la_name;
	XCanvas can;
	JButton bt_prev, bt_next;
	JPanel p_west, p_center, p_south;
	JScrollPane scroll;
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
	ArrayList<Thumb> list = new ArrayList();
	public GalleryApp() {
		can = new XCanvas(dir+src[n]);
		p_west = new JPanel();
		p_west.setBackground(Color.yellow);
		p_center = new JPanel();
		p_center.setBackground(Color.green);
		scroll = new JScrollPane(p_west);
		la_name = new JLabel(src[n]+"    "+(n+1)+"/"+src.length);
		la_name.setBackground(Color.red);
		la_name.setFont(new Font("Verdana", Font.BOLD, 25));
		p_south = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		
		for(int i=0; i<src.length; i++) {
			Thumb thumb = null;
			list.add(thumb=new Thumb(dir+src[i], this));
			p_west.add(thumb);
		}
		
		p_west.setPreferredSize(new Dimension(100, 600));
		p_center.setPreferredSize(new Dimension(700, 600));
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);
		p_center.add(bt_prev);
		p_center.add(bt_next);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		add(scroll, BorderLayout.WEST);
		add(p_center);
		
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_prev) {
			n--;
			if(n < 0)
				n=src.length-1;
			updateImg();
		}
		else if(obj == bt_next) {
			n++;
			if(n > src.length-1)
				n=0;
			//JOptionPane.showMessageDialog(this, "마지막이미지");
			updateImg();
		}
	}
	public void updateImg() {
		can.setSrc(dir+src[n]);
		can.repaint();
		la_name.setText(src[n]+"    "+(n+1)+"/"+src.length);
	}

	public static void main(String[] args) {
		new GalleryApp();
	}
}
