package day1104.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBApp {

	public static void main(String[] args) {
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 찾기 성공");
			String str = "jdbc:oracle:thin:@localhost:1521:XE"; // 접속문자열
			//접속시도
			Connection con = null;
			//접속이 성공되면 con이 반환, 실패면 null
			con = DriverManager.getConnection(str,"user1104","user1104");
			if(con==null) {
				System.out.println("접속실패");
			}else {
				System.out.println("접속 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 찾기 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
