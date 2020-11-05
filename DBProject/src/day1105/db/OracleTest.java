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
		System.out.println("�ε强��");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "user1104";
		String password = "user1104";

		String sql = "insert into member(member_id, name, age, phone) ";
		sql += "values(seq_member.nextval, 'rush', 40, '001')";

		con = DriverManager.getConnection(url,user,password);
		if(con == null)
			System.out.println("���ӽ���");
		else {
			System.out.println("���Ӽ���");

		pstmt = con.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		if(result != 1) 
			System.out.println("insert ����");
		else
			System.out.println("insert ����");
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
					System.out.println("pstmt ����");
				}
				if(con != null) {
					con.close();
					System.out.println("con ����");
			}
			}catch(SQLException e) { System.out.println(e);}
		}
	}
}
