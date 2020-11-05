package day1105.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmpApp extends JFrame implements ActionListener{
	JButton bt_connect, bt_load;
	JTextArea area;
	JScrollPane scroll;
	Connection con;
	PreparedStatement pstmt;
	ResultSet set;
	
	public EmpApp() {
		bt_connect = new JButton("Connect");
		bt_load = new JButton("Load");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		con = null;
		pstmt=null;
		
		area.setPreferredSize(new Dimension(780, 500));
		
		setLayout(new FlowLayout());
		
		add(bt_connect);
		add(bt_load);
		add(scroll);
		
		bt_connect.addActionListener(this);
		bt_load.addActionListener(this);
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt_connect)
			connect();
		else if(obj == bt_load)
			load();
	}
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			area.append("드라이버 로드 성공\n");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "user1104";
			String password = "user1104";
			con = DriverManager.getConnection(url,user,password);
			
			if(con == null)
				area.append("접속 실패\n");
			else {
				area.append("접속 성공\n");
				
			}
		} catch (ClassNotFoundException e) {
			area.append("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		String sql = "select * from emp";

		try {
			pstmt = con.prepareStatement(sql);
			//pstmt.executeQuery(sql);
			set = pstmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EmpApp();
	}
}
