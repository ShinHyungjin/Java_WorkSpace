package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;

class App1
{
	public static void main(String[] args) {
		Frame frame = new Frame();
		Button bt = new Button("��ư");
		FlowLayout flow = new FlowLayout();
		TextField tf = new TextField("ȸ������",10);
		Checkbox cb = new Checkbox("����",true);
		TextArea ta = new TextArea(10,10);
		Label l = new Label("�������");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("D:/IT_Korea_Class/Java/project1026/res/1.jpg");
		
		System.out.println(img);

		frame.setSize(500,500);
		bt.setSize(200,200);
		tf.setSize(50,50);
		cb.setSize(50,50);

		frame.setVisible(true);
		frame.setLayout(flow);
		frame.add(bt);
		frame.add(tf);
		frame.add(cb);
		frame.add(ta);
		frame.add(l);
		

	}
}
