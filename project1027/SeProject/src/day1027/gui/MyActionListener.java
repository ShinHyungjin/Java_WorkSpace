package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyActionListener implements ActionListener{
	JTextArea area;
	JTextField jt;
	@Override
	public void actionPerformed(ActionEvent e) {
		area.append(jt.getText()+"\n");
		jt.setText("");
	}
	public MyActionListener(JTextArea area, JTextField jt) {
		this.area = area;
		this.jt = jt;
	}
}
