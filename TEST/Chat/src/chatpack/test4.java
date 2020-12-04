package chatpack;

import java.net.*;
import javax.swing.*;

public class test4 {

       public static void main(String[] args) throws MalformedURLException {
           JFrame frame = new JFrame("Test");

           ImageIcon loading = new ImageIcon(
        		   new URL("https://i.pinimg.com/originals/84/47/d8/8447d8400d397ad5ffd6059247026ee2.gif"));
           frame.add(new JLabel(loading, JLabel.CENTER));

           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(400, 300);
           frame.setVisible(true);
       }
}