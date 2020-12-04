package chatpack;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class test extends JFrame{
	public test() {
		JPanel panel = new JPanel();
        add(panel);

        JLabel label1 = new JLabel("Name",SwingConstants.LEFT);     
        label1.setPreferredSize(new Dimension(200,100));
        
        JLabel label2 = new JLabel("Activities",SwingConstants.LEFT);
        label2.setPreferredSize(new Dimension(200,100));
        
        
        panel.add(label1);
        panel.add(label2);

        
        setLayout(new FlowLayout());
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new test();
	}
}
