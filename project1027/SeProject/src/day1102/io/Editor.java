package day1102.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Editor extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu menu;
	JMenuItem item_new, item_open, item_save, item_saveas;
	JTextArea area;
	JFileChooser ch;
	File f;
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	public Editor() {
		bar = new JMenuBar();
		menu = new JMenu("파일");
		item_new = new JMenuItem("새로만들기");
		item_open = new JMenuItem("열기");
		item_save = new JMenuItem("저장");
		item_saveas = new JMenuItem("다른이름으로 저장");
		area = new JTextArea();
		ch = new JFileChooser("D:/IT_Korea_Class/Java/project1027/SeProject/res/data");
		
		item_new.addActionListener(this);
		item_open.addActionListener(this);
		item_save.addActionListener(this);
		item_saveas.addActionListener(this);
		
		setJMenuBar(bar);
		bar.add(menu);
		menu.add(item_new);
		menu.add(item_open);
		menu.add(item_save);
		menu.add(item_saveas);
		add(area);
		
		
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 중앙
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == item_new) {
			
		}else if(obj == item_open) {
			open();
		}else if(obj == item_save) {
			save();
		}else if(obj == item_saveas) {
			
		}
	}
	public void open() {
		if(ch.showOpenDialog(this)== 0) {
			f = ch.getSelectedFile();
			this.setTitle(f.getAbsolutePath());
			try {
				int data;
				String data2;
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				try {
					int count=0;
					while(true) {
					data = fr.read();
					data2 = br.readLine();
					System.out.println(++count);
					if(data2 == null)
						break;
					area.append(data2+"\n");
					//if(data == -1)
						//break;
					//area.append(Character.toString((char)data));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	public void save() {
		try {
			fw = new FileWriter(f);
			//bw = new BufferedWriter(fw);
			fw.write(area.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw !=null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	public static void main(String [] args) {
		new Editor();
	}
}
