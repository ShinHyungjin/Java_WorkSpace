package chatpack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class test2 extends JFrame{
	JPanel p;
	JLabel la,la1,la2;
	Font customFont;
	
	public test2() {
		//create the font

		try {
		    //create the font to use. Specify the size!
		    customFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:/IT_Korea_Class/Java/TEST/BMEULJIROTTF.ttf")).deriveFont(30f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
	p=new JPanel();
	la=new JLabel("SoomCo 가나다라마",SwingConstants.CENTER);
	la1=new JLabel("SoomCo 가나다라마",SwingConstants.CENTER);
	la2=new JLabel("SoomCo 가나다라마",SwingConstants.CENTER);
		
	Font font1 = new Font("메이플스토리 OTF",Font.PLAIN,30);
	Font font2=new Font("verdana",Font.BOLD,30);
	Font font3=new Font("BMEULJIROTTF",Font.PLAIN,30);
	
	la1.setForeground(Color.magenta);
	la2.setForeground(Color.BLACK);
	
//	la.setFont(font1);
//	la1.setFont(font2);
//	la2.setFont(font2);
	
	la.setFont(customFont);
	
	p.add(la);
	p.add(la1);
	p.add(la2);
	add(p);

	setSize(300,300);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new test2();
	}
}