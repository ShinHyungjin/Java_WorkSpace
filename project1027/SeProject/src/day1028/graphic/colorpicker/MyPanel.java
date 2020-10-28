package day1028.graphic.colorpicker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
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
			add(mp[i]);
		}
	}
}
