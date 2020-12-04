package chatpack;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class test3 {
	JTextField a = new JTextField("tf",12);
	JLabel b = new JLabel("la");
	
	public test3() {
		test(a);
		test(b);
		
	}

	public void test(Component c) {
		System.out.println(c.equals(a));
	}
	
	public static void main(String[] args) {
		new test3();
	}

}
