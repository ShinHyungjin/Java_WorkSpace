package day1029.collection;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomButton extends JButton implements ActionListener{
	public CustomButton(int n) {
		this.addActionListener(this);
		this.setText("버튼"+n);
	}
	public void actionPerformed(ActionEvent e) {
		this.setBackground(Color.green);
		
	}
}
