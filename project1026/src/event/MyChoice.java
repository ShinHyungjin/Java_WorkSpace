package event;
import java.awt.event.*;
class MyChoice implements ItemListener
{
	public void itemStateChanged(ItemEvent e) {
		System.out.println("지금 아이템 : " + e.getItem() + "\n\n");
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
