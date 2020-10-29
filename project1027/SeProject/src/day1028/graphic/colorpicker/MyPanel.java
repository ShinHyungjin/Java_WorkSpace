package day1028.graphic.colorpicker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener{
	static JPanel jp;
	JPanel[] mp = new JPanel[7];
	Color [] col = {Color.RED, Color.orange, Color.yellow,
			Color.green, Color.cyan, Color.blue, Color.pink };
	public MyPanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(770,110));
		for(int i=0; i<mp.length; i++) {
			mp[i] = new JPanel();
			mp[i].setPreferredSize(new Dimension(100, 100));
			mp[i].setBackground(col[i]);
			mp[i].setName(col[i].toString());
			add(mp[i]);
			mp[i].addMouseListener(this);
		}
	}
	public MyPanel(JPanel jp) {
		this.jp = jp;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0; i<7; i++) {
			if(e.getSource().equals(mp[i])) {
				System.out.println((i+1)+"번째 JPanel");
				jp.setBackground(mp[i].getBackground());
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
