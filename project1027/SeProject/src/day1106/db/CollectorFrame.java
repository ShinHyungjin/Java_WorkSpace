package day1106.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CollectorFrame extends JFrame{
	JTextField t_url;
	JButton bt;
	JButton bt_apply;
	ShoppingApp shoppingApp;
	BufferedImage bi;
	File file;
	public CollectorFrame(ShoppingApp shoppingApp) {
		this.shoppingApp = shoppingApp;
		setLayout(new FlowLayout());
		
		t_url = new JTextField();
		bt = new JButton("수집실행");
		bt_apply = new JButton("업데이트");
		
		t_url.setPreferredSize(new Dimension(580, 40));
		add(t_url);
		add(bt);
		add(bt_apply);
		
		bt.addActionListener(new ActionListener() {	
		@Override
			public void actionPerformed(ActionEvent e) {
				collect();
			}
		});
		bt_apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shoppingApp.getTargetImage(file.getAbsolutePath());
				shoppingApp.preview(shoppingApp.can);
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void collect() {
		try {
			URL url = new URL(t_url.getText());
			bi = ImageIO.read(url);
			
			long time = System.currentTimeMillis();
			System.out.println(time);
			
			String filename = FileManager.getFilename(t_url.getText());
			String ext = FileManager.getExtend(filename);
			
			file = new File("D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/"+time+"."+ext);
			ImageIO.write(bi, ext, file);
			JOptionPane.showMessageDialog(this, "가져오기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
