package gui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.TextField;
public class MyActionListener implements ActionListener
{
	Button bt1, bt2;
	TextField tx;
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt1) {
			System.out.println(obj + "를 클릭했음\n");
		}else if(obj==bt2){
			System.out.println(obj + "를 클릭했음\n");
		}else if(obj==tx){
			System.out.println(obj + "를 클릭했음\n");
		}
	}
	public MyActionListener(Button bt1, Button bt2, TextField tx) {
		this.bt1 = bt1;
		this.bt2 = bt2;
		this.tx = tx;
	}
}
