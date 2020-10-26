package event;
import java.awt.event.*;
class MyMouse implements MouseListener
{
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked\n" +  e + "\n\n");
	}

	public void mouseEntered(MouseEvent e){
		System.out.println("Entered\n" +  e + "\n\n");
	}

	public void mouseExited(MouseEvent e){
		System.out.println("Exited\n" +  e + "\n\n");
	}

	public void mousePressed(MouseEvent e){
		System.out.println("Pressed\n" +  e + "\n\n");
	}

	public void mouseReleased(MouseEvent e){
		System.out.println("Released\n" +  e + "\n\n");
	}

	public static void main(String[] args) 
	{
		
	}
}
