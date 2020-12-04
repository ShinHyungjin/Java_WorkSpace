package chatpack;

import javax.swing.*;
import java.awt.*;

public class Demonstration {
	public Demonstration() {
		JFrame frame = new JFrame("Hover Button Demonstration");
		frame.setLayout(new GridBagLayout());
		frame.add(new HoverButton("Hover Button!!"));

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Demonstration();
			}
		});
	}
}