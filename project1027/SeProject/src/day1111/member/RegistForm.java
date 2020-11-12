package day1111.member;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class RegistForm extends JPanel {
	JPanel p_container;// 묶기위한 컨테이너
	JTextField t_id;
	JPasswordField t_pass;
	JTextField t_name;
	JButton bt, bt_login;
	BoardApp boardApp;
	
	Connection con;

	public RegistForm(BoardApp boardApp) {
		this.boardApp = boardApp;
		con = boardApp.getCon();

		p_container = new JPanel();
		t_id = new JTextField(30);
		t_pass = new JPasswordField(30);
		t_name = new JTextField(30);
		bt = new JButton("가입");
		bt_login = new JButton("로그인");

		p_container.setBackground(Color.YELLOW);
		p_container.setPreferredSize(new Dimension(400, 200));

		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(t_name);
		p_container.add(bt);
		p_container.add(bt_login);

		add(p_container);
		setVisible(true);

		// 가입버튼과 리스너 연결
		bt.addActionListener((e) -> {
			regist();
		});
		bt_login.addActionListener((e) -> {
			boardApp.setPage(BoardApp.MEMBER_LOGIN);
		});
	}

	/*
	 * 오라클에 접속하여 insert 실행!! 1.드라이버로드 2.접속 3.쿼리문실행 4.db닫기
	 */
	public void regist() {
		PreparedStatement pstmt=null;
		String sql = "insert into board_member(member_id, m_id, m_pass, m_name) ";
		sql += "values(seq_board_member.nextval, ?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t_id.getText());
			pstmt.setString(2, String.valueOf(t_pass.getPassword()));
			pstmt.setString(3, t_name.getText());

			int result = pstmt.executeUpdate(); // DML = Update, select = Query
			if (result == 0) {
				JOptionPane.showMessageDialog(this, "가입실패!");
			} else {
				JOptionPane.showMessageDialog(this, "가입완료!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
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
