package gui;
import java.awt.*;
class GridTest
{
	public static void main(String[] args) 
	{
		GridLayout layout = new GridLayout();
		Frame frame = new Frame();

		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLayout(layout);

		Panel p = new Panel();
		
		Button bt1 = new Button("��ư1");
		Button bt2 = new Button("��ư2");
		Button bt3 = new Button("��ư3");

		p.add(bt1);
		p.add(bt2);
		p.add(bt3);

		frame.add(p);

	}
}
