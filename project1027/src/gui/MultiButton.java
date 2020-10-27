package gui;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
class MultiButton extends Frame 
{
	Button bt1, bt2;
	TextField tx;
	public MultiButton() {
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		tx = new TextField(20);
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(tx);

		MyActionListener listener = new MyActionListener(bt1, bt2, tx);
		
		bt1.addActionListener(listener);
		bt2.addActionListener(listener);
		tx.addActionListener(listener);

		setSize(300,400);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new MultiButton();
	}
}
