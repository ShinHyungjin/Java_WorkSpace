package day1105.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmpApp2 extends JFrame implements ActionListener{
	JButton bt_connect, bt_load;
	JTextArea area;
	JScrollPane scroll;
	Connection con;
	PreparedStatement pstmt;
	ResultSet set;
	
	public EmpApp2() {
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
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(set != null)
					try {
						set.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				if(pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				if(con != null)
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				System.exit(0);
			}
		});
		
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
			Class.forName("org.mariadb.jdbc.Driver");
			area.append("드라이버 로드 성공\n");
			String url = "jdbc:mariadb://localhost/db1105";
			String user = "root";
			String password = "1234";
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
			area.append("\nEMPNO\t ENAME\t job\t MRG\t HIREDATE\t\t SAL\t COMM\t DEPTNO\t \n");
			while(set.next()) {
				for(int j=1; j<9; j++) {
					area.append(set.getString(j)+"\t");
					System.out.print(set.getString(j)+"\t");
				}
				System.out.println("");
				area.append("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EmpApp2();
	}
}
