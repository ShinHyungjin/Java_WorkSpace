package event;
import java.awt.event.*;
class MyKey implements KeyListener
{
	public void keyPressed(KeyEvent e) {
		System.out.println("누른 키는 " + e.getKeyCode());
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	public static void main(String[] args) 
	{
		
	}
}
