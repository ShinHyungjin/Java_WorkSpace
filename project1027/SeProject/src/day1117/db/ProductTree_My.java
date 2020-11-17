package day1117.db;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProductTree_My extends JFrame {
	String[] category = { "상의", "하의", "액세서리", "신발" };
	String[][] product = { { "티셔츠", "점퍼", "니트", "가디건" }, { "청바지", "반바지", "면바지", "핫바지" }, { "귀걸이", "목걸이", "반지", "팔찌" },
			{ "구두", "운동화", "스니커즈", "샌들" } };
	
	String [] top_category = new String[4];
	String [][] sub_category = new String[4][4];
	
	JTree tree;
	JScrollPane scroll;
	DefaultMutableTreeNode top;

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="user1104";
	String password="user1104";
	Connection con;

	public ProductTree_My() {
		//DB연동
		
		connect();
		getTopcategory();
		getSubcategory();
		
		for(int i=0; i<4; i++) {
			System.out.println("top "+ i + " 번째" +top_category[i]);
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.println("sub "+ i +","+ j + "번째" + sub_category[i][j]);
			}
		}
		
		
		//노드 생성은 외부 메서드로 공수받자
		
		top = new DefaultMutableTreeNode("상품정보");
		for (int i = 0; i < top_category.length; i++) {
			top.add(getCreateNode(top_category[i], sub_category[i]));
		}
		
//		top = new DefaultMutableTreeNode("상품정보");
//		for (int i = 0; i < category.length; i++) {
//			top.add(getCreateNode(category[i], product[i]));
//		}

		tree = new JTree(top);
		scroll = new JScrollPane(tree);

		add(scroll);

		setSize(400, 500);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
		});
	}

	public DefaultMutableTreeNode getCreateNode(String parentName, String[] childName) {
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);

		if (childName != null) {
			for (int i = 0; i < childName.length; i++) {
				parent.add(new DefaultMutableTreeNode(childName[i]));
			}
		}
		return parent;
	}
	
	public void connect() {
		try {
			Class.forName(driver); //드라이버 로드 
			con = DriverManager.getConnection(url, user, password); //접속시도
			if(con==null) {
				JOptionPane.showMessageDialog(this, user+"계정의 접속에 실패하였습니다.");
			}else {
				this.setTitle(user+" 계정으로 접속 중..."); //프레임 제목에 성공 출력 
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void getTopcategory() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from Topcategory";
		
		int count=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				top_category[count] = rs.getString("name");
				count++;
			}
			
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
	public void getSubcategory() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from Subcategory";
	
		int count=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sub_category[rs.getInt("Topcategory_id")-1][count] = rs.getString("name");
				count++;
				if(count%4==0)
					count=0;
			}
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
	public static void main(String[] args) {
		new ProductTree_My();
	}
}
