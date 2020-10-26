package gui;
import java.awt.*;
class Border_Id
{
	public static void main(String[] args) 
	{
		GridLayout gl = new GridLayout(2,2);
		Frame frame = new Frame();
		Panel p = new Panel();
		Panel p2 = new Panel();

		p.setLayout(gl);
		p.add(new Label("Id"));
		p.add(new TextField());
		p.add(new Label("Pw"));
		p.add(new TextField());
		p2.add(new Button("가입"));
		p2.add(new Button("취소"));

		frame.add(p, BorderLayout.CENTER);
		frame.add(p2, BorderLayout.SOUTH);
		
				
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
