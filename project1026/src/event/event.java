package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;
class event extends Frame
{
	Button bt;
	TextField t;
	Choice ch;
	public event() {
		bt = new Button("버튼");
		t = new TextField(15);
		ch = new Choice();
		ch.add("사과");
		ch.add("바나나");
		this.setLayout(new FlowLayout());
		this.add(bt);
		this.add(t);
		this.add(ch);

		bt.addActionListener(new MyListener());
		t.addKeyListener(new MyKey());
		//this.addMouseListener(new MyMouse());
		ch.addItemListener(new MyChoice());
		this.addWindowListener(new MyWindow());

		this.setSize(500,500);
		this.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new event();
	}
}
