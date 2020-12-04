package chatpack;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class LabelSize extends Applet implements ActionListener {
	MyPanel p;
	Label l;
	Button b1, b2;
	TextField t1, t2;

	public void init() {
		setLayout(new FlowLayout());
		t1 = new TextField(10);
		b1 = new Button("Change Label");
		add(t1);
		add(b1);
		t2 = new TextField(10);
		b2 = new Button("Change drawString");
		add(t2);
		add(b2);
		l = new Label("label text");
		add(l);

		// a Panel with a drawString call
		p = new MyPanel();
		add(p);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			l.setText(t1.getText());
			l.invalidate();
			validate();
		}
		if (e.getSource() == b2) {
			p.someString = t2.getText();
			p.repaint();
		}
	}
}

class MyPanel extends Panel {
	String someString = "drawstring";

	MyPanel() {
		super();
	}

	public void paint(Graphics g) {
		g.drawString(someString, 10, 50);
	}

	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}
}