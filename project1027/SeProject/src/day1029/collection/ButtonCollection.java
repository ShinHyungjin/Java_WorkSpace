package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton create, bgcol;
	CustomButton bt;
	ArrayList<JButton> btn = new ArrayList();
	/*
	 * HashSet<JButton> hs = new HashSet(); Iterator<JButton> it;
	 */
	static int n=1;
	public ButtonCollection() {
		p_north = new JPanel();
		p_north.setPreferredSize(new Dimension(500, 100));
		p_north.setLayout(new FlowLayout());
		
		create = new JButton("생성");
		bgcol = new JButton("배경색");
		bgcol.setBackground(Color.RED);
		
		p_north.add(create);
		p_north.add(bgcol);
		
		p_center = new JPanel();
		p_center.setPreferredSize(new Dimension(500, 500));
		p_center.setLayout(new FlowLayout());
		p_center.setBackground(Color.blue);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		create.addActionListener(this);
		bgcol.addActionListener(this);
		
		setSize(500,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == create)
			create();
		else if(obj == bgcol)
			setBg();
	}
	public void create() {
		System.out.println(n);
		int a=1;
		bt = new CustomButton(n);
		btn.add(bt);
		p_center.add(bt);
		n++;
//		hs.add(new JButton("버튼"+n));
//		it = hs.iterator();
//		
//		while(it.hasNext()) {
//			if(a==n)
//				p_center.add(it.next());
//			else
//				a++;
//		}
		p_center.updateUI();
	}
	public void setBg() {
		for(int i=0; i<btn.size(); i++) {
			btn.get(i).setBackground(bgcol.getBackground());
		}
	}
	public static void main(String[] args) {
		new ButtonCollection();
	}
}
