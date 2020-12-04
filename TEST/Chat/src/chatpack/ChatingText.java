package chatpack;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChatingText extends JLabel{
	String text;
	ChatA chatA;
	
	public ChatingText(String text, ChatA chatA) {
		this.text = text;
		this.chatA = chatA;
	}
	public JLabel test() {
		JLabel ch = new JLabel(text,SwingConstants.RIGHT);
		ch.setPreferredSize(new Dimension(200,20));
		return ch;
	}
}
