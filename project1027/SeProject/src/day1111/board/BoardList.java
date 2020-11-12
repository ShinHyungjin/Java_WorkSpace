/*게시물 목록 페이지*/
package day1111.board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

public class BoardList extends JPanel {
	JTable table;
	JScrollPane scroll;
	JButton bt;
	BoardApp boardApp;
	BoardModel boardModel;
	
	Connection con;
	
	public BoardList(BoardApp boardApp) {
		this.boardApp=boardApp;
		con = boardApp.getCon();
		table = new JTable(boardModel=new BoardModel());
		scroll = new JScrollPane(table);
		bt=new JButton("글등록");
		
		getList();
		
		setLayout(new BorderLayout());
		add(scroll);
		add(bt, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(780, 500));
		setVisible(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				BoardDetail boardDetail = (BoardDetail) boardApp.getPages(BoardApp.BOARD_DETAIL);
				String board_id = (String)table.getValueAt(table.getSelectedRow(), 0);
				boardDetail.getDetail(Integer.parseInt(board_id));
				boardApp.setPage(BoardApp.BOARD_DETAIL);//상세보기
			}
		});
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//글쓰기 폼의 작성자에, 아이디 넣어두기!!
				BoardWrite page=(BoardWrite)boardApp.getPages(BoardApp.BOARD_WRITE);
				page.t_writer.setText(boardApp.getBoardMember().getM_id());
				
				boardApp.setPage(BoardApp.BOARD_WRITE);//글쓰기 폼 보여주기 
			}
		});
	}
	public void getList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board order by board_id desc";
		
		try {
			//스크롤이 가능하고 읽기전용 rs = next능력에 자유자재로 이동하는 능력
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pstmt.executeQuery();
			rs.last(); // rs를 마지막으로 보내 층수를 구하고
			String [][] records = new String[rs.getRow()][5];
			rs.beforeFirst(); // 다시 rs를 처음으로 보냄
			int index=0;
			while(rs.next()) {
				String [] arr = new String[5];
				arr[0] = rs.getString("board_id");
				arr[1] = rs.getString("title");
				arr[2] = rs.getString("writer");
				arr[3] = rs.getString("regdate");
				arr[4] = rs.getString("hit");
				records[index++] = arr;
			}
			//records 를 BoardModel의 data에 대입
			boardModel.data = records;
			table.updateUI();
			
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