package event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MultiActionListener implements ActionListener
{ 
	public void actionPerformed(ActionEvent e) {
		System.out.println("\t" + e.getSource() + "\n");
		System.out.println("\t" + e.paramString() + "\n");
	}
	public static void main(String[] args) 
	{
		
	}
}
