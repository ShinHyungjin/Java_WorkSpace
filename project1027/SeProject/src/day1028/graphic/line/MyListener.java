package day1028.graphic.line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener{
	XCanvas can;
	public MyListener(XCanvas can) {
		this.can = can;
	}
	public void actionPerformed(ActionEvent e) {
		can.repaint();
	}
}
