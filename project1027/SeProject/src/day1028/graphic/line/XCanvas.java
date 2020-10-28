package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Graphics;

public class XCanvas extends Canvas{
	LineMaker lm;
	public void setLineMaker(LineMaker lm) {
		this.lm = lm;
	}
	public void paint(Graphics g) {
		int x1, x2, y1, y2;
		x1 = Integer.parseInt(lm.tx1.getText());
		x2 = Integer.parseInt(lm.tx2.getText());
		y1 = Integer.parseInt(lm.ty1.getText());
		y2 = Integer.parseInt(lm.ty2.getText());
		g.drawLine(x1, x2, y1, y2);
	}
}
