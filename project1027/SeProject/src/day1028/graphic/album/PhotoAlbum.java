package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
	AlbumPanel p;
	JPanel p_south;
	JButton bt_prev, bt_next;
	public PhotoAlbum() {
		p = new AlbumPanel();
		p.setBackground(Color.yellow);
		
		p_south = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		
		add(p);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south, BorderLayout.SOUTH);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_prev) {
			if(p.n < 9)
				p.n = p.n + 1;
			else
				p.n = 0;
		} else if(obj == bt_next) {
			if(p.n > 0)
				p.n = p.n - 1;
			else
				p.n = 9;
		}
		p.repaint();
	}
	public static void main(String[] args) {
		new PhotoAlbum();
	}
}
