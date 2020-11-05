package day1105.db;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableApp extends JFrame{
	JTable table;
	String [] column = {"번호","이름","연락처","주소","성별"};
	String [][] data = { {"1","Batman","011","고담시","남"},
			{"2","superman","012","크립톤","남"},
			{"3","wonder","013","아마존","여"}
	};
	JScrollPane scroll;
	public TableApp() {
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		setLayout(new FlowLayout());
		add(scroll);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				System.out.println(row+"행 "+col+"열"+"\tData : "+table.getValueAt(row, col));
			}
		});
		
		setSize(700,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TableApp();
	}
}
