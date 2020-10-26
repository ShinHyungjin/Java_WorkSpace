package event;
import java.awt.*;
import java.awt.event.*;
class MyMultiButton extends Frame
{
	Button bt1, bt2;
	public MyMultiButton() {
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		
		this.setLayout(new FlowLayout());

		this.add(bt1);
		this.add(bt2);

		bt1.addActionListener(new MultiActionListener());
		bt2.addActionListener(new MultiActionListener());

		this.setSize(500,500);
		this.setVisible(true);
	
	}

	public static void main(String[] args) 
	{
		new MyMultiButton();	
	}
}
