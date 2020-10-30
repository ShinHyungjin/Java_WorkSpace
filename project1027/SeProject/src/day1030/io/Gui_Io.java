package day1030.io;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gui_Io extends JFrame implements ActionListener {
	JLabel l_ori, l_dest;
	JTextField t_ori, t_dest;
	JButton copy;

	FileInputStream fs;
	FileOutputStream os;

	String s_ori, s_dest;

	public Gui_Io() {
		l_ori = new JLabel("원본");
		l_ori.setPreferredSize(new Dimension(50, 50));

		t_ori = new JTextField();
		t_ori.setPreferredSize(new Dimension(280, 50));

		l_dest = new JLabel("복사");
		l_dest.setPreferredSize(new Dimension(50, 50));

		t_dest = new JTextField();
		t_dest.setPreferredSize(new Dimension(280, 50));

		copy = new JButton("Copy");
		copy.setPreferredSize(new Dimension(200, 50));

		add(l_ori);
		add(t_ori);
		add(l_dest);
		add(t_dest);
		add(copy);

		copy.addActionListener(this);
		
		JFileChooser ch = new JFileChooser();
		ch.showOpenDialog(this);

		setLayout(new FlowLayout());
		setSize(360, 240);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		s_ori = t_ori.getText();
		s_dest = t_dest.getText();

		try {
			fs = new FileInputStream(s_ori);
			os = new FileOutputStream(s_dest);
			int data;

			while (true) {
				data = fs.read();
				if (data == -1)
					break;
				os.write((char) data);
			}
			JOptionPane.showMessageDialog(this, "복사완료");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (fs != null)
				try {
					fs.close();
					System.out.println("fs종료");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if (os != null)
				try {
					os.close();
					System.out.println("os종료");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}

	}

	public static void main(String[] args) {
		new Gui_Io();
	}
}
