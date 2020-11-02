package day1102.event;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowApp extends JFrame{
	
	public WindowApp() {
		this.addWindowListener(new MyWinAdapter() {
			public void windowClosing(WindowEvent e) {
			System.out.println("문이닫히네요");
			System.exit(0);
			}
		});
		setSize(300,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new WindowApp();
	}
}
