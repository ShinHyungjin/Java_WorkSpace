package day1111.board;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	Connection con;
	Board board;
	public BoardDetail(BoardApp boardApp) {
		this.boardApp = boardApp;
		con = boardApp.getCon();
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
				t_title.setText(""); 
				t_writer.setText("");
				content.setText("");
				boardApp.setPage(boardApp.BOARD_LIST);
			}
		});
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 삭제 하시겠습니까?","삭제명령",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					
				}
			}
		});
		bt_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 수정 하시겠습니까?","수정명령",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					
				}
			}
		});
	}
	public void getDetail(int board_id) {
		String sql = "select * from board where board_id="+board_id;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		board = null;
		
		try {
			//스크롤이 가능하고 읽기전용 rs = next능력에 자유자재로 이동하는 능력
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
			}
			
			t_title.setText(String.valueOf(board.getBoard_id())); 
			t_writer.setText(board.getWriter());
			content.setText(board.getContent());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
