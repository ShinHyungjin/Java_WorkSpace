package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWinAdapter extends WindowAdapter{

	public MyWinAdapter() {
		
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("문이닫히네요");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("문이닫히네요");
		System.exit(0);
	}
}
