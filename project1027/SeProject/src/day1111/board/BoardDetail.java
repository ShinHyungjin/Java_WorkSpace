package day1111.board;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardDetail extends JPanel{
	JTextField t_title, t_writer;
	JTextArea content;
	JScrollPane scroll;
	
	JButton bt_edit, bt_del, bt_list;
	BoardApp boardApp;
	public BoardDetail(BoardApp boardApp) {
		this.boardApp = boardApp;
		t_title = new JTextField();
		t_writer = new JTextField();
		content = new JTextArea();
		scroll = new JScrollPane(content);
		bt_edit = new JButton("글수정");
		bt_del = new JButton("글삭제");
		bt_list = new JButton("목록보기");
		
		t_title.setPreferredSize(new Dimension(780,35));
		t_writer.setPreferredSize(new Dimension(780,35));
		scroll.setPreferredSize(new Dimension(780,200));
		
		bt_edit.setPreferredSize(new Dimension(120,45));
		bt_del.setPreferredSize(new Dimension(120,45));
		bt_list.setPreferredSize(new Dimension(120,45));
		
		add(t_title);
		add(t_writer);
		add(scroll);
		add(bt_edit);
		add(bt_del);
		add(bt_list);
		
		setVisible(false);
		setPreferredSize(new Dimension(780,500));
		
		bt_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardApp.setPage(boardApp.BOARDLIST);
			}
		});
	}
}
