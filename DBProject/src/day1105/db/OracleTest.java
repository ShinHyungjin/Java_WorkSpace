package day1105.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class OracleTest 
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("로드성공");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "user1104";
		String password = "user1104";

		String sql = "insert into member(member_id, name, age, phone) ";
		sql += "values(seq_member.nextval, 'rush', 40, '001')";

		con = DriverManager.getConnection(url,user,password);
		if(con == null)
			System.out.println("접속실패");
		else {
			System.out.println("접속성공");

		pstmt = con.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		if(result != 1) 
			System.out.println("insert 실패");
		else
			System.out.println("insert 성공");
		}		
	} catch(ClassNotFoundException e) {
		System.out.println(e);
		e.printStackTrace();
		}
	   catch(SQLException e) {
		System.out.println(e);
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					System.out.println("pstmt 종료");
				}
				if(con != null) {
					con.close();
					System.out.println("con 종료");
			}
			}catch(SQLException e) { System.out.println(e);}
		}
	}
}
