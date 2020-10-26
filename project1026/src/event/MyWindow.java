package event;
import java.awt.event.*;
public class MyWindow implements WindowListener
{
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated\t"+ e + "\n");
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed\t"+ e + "\n");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("Closing\t"+ e + "\n");
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated\t"+ e + "\n");
	}
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified\t"+ e + "\n");
	}
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified\t"+ e + "\n");
	}
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened\t"+ e + "\n");
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
