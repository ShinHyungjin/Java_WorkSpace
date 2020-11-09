/*
 * 쇼핑몰 상품관리 프로그램을 제작하기
 * */
package day1106.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import common.image.ImageUtil;

public class ShoppingApp extends JFrame {
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "user1104";
	String password = "user1104";
	Connection con = null;
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
	JFileChooser fc = new JFileChooser("D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/");
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image img;
	File file;
	ProductController productController;
	CollectorFrame collectorFrame;

	JPanel p_west; // 전체 중 서쪽
	JPanel p_center; // 전체 중 가운데
	JPanel c_north; // 가운데 중 북쪽
	JPanel c_center; // 가운데 중 센터
	JPanel p_east;// 전체 중 동쪽

	// 등록폼 관련
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_brand;
	JTextField t_price;
	JButton bt_find; // 이미지 찾아보기
	JButton bt_collect; // 이미지 수집하기(원격지 이미지를 내 HDD로)
	JPanel can;// 이미지 미리보기 그려질 곳
	JButton bt_regist;

	// 센터영역 - 검색관련
	Choice ch_category;// 검색 카테고리
	JTextField t_keyword; // 검색어
	JButton bt_search; // 검색버튼
	JTable table;
	JScrollPane scroll;

	// 동쪽영역
	Choice ch_top2;
	Choice ch_sub2;
	JTextField t_name2;
	JTextField t_brand2;
	JTextField t_price2;
	JButton bt_find2; // 이미지 찾아보기
	JPanel can2;// 이미지 미리보기 그려질 곳
	JButton bt_edit; // 수정버튼
	JButton bt_del; // 삭제버튼

	public ShoppingApp() {
		// 서쪽영역 생성
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_name = new JTextField();
		t_brand = new JTextField();
		t_price = new JTextField();
		bt_find = new JButton("이미지찾기");
		can = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, can);
			}
		};
		bt_collect = new JButton("인터넷수집");
		bt_regist = new JButton("등록");

		// 서쪽 조립
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_brand);
		p_west.add(t_price);
		p_west.add(bt_find);
		p_west.add(bt_collect);
		p_west.add(can);
		p_west.add(bt_regist);

		// 스타일적용
		ch_top.setPreferredSize(new Dimension(135, 30));
		ch_sub.setPreferredSize(new Dimension(135, 30));
		t_name.setPreferredSize(new Dimension(135, 30));
		t_brand.setPreferredSize(new Dimension(135, 30));
		t_price.setPreferredSize(new Dimension(135, 30));
		bt_find.setPreferredSize(new Dimension(135, 30));
		bt_collect.setPreferredSize(new Dimension(135, 30));
		can.setPreferredSize(new Dimension(135, 115));

		ch_top.add("--choose category--");

		p_west.setPreferredSize(new Dimension(150, 600));
		// p_west.setBackground(Color.YELLOW);

		// 프레임에 서쪽 영역 붙이기
		add(p_west, BorderLayout.WEST);

		// 가운데 영역 생성
		c_north = new JPanel();
		c_center = new JPanel();
		ch_category = new Choice();
		t_keyword = new JTextField();
		bt_search = new JButton("검색");
		table = new JTable(productController=new ProductController());
		scroll = new JScrollPane(table);

		// 스타일 적용
		c_north.setBackground(Color.PINK);
		ch_category.setPreferredSize(new Dimension(130, 30));
		t_keyword.setPreferredSize(new Dimension(380, 30));
		bt_search.setPreferredSize(new Dimension(120, 30));
		c_center.setLayout(new BorderLayout());

		ch_category.add("product_name");
		ch_category.add("brand");
		
		// 가운데-검색영역 조립
		c_north.add(ch_category);
		c_north.add(t_keyword);
		c_north.add(bt_search);

		// 가운데-테이블영역 조립
		c_center.add(scroll);

		// 가운데 영역의 전체 패널에 두패널 부착
		p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(c_north, BorderLayout.NORTH);
		p_center.add(c_center);

		// 가운데 전체패널을 프레임에 부착
		add(p_center);

		// 동쪽영역 생성
		p_east = new JPanel();
		ch_top2 = new Choice();
		ch_sub2 = new Choice();
		t_name2 = new JTextField();
		t_brand2 = new JTextField();
		t_price2 = new JTextField();
		bt_find2 = new JButton("이미지찾기");
		can2 = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, can2);
			}
		};
		ch_top2.add("--choose category--");
		bt_edit = new JButton("수정");
		bt_del = new JButton("삭제");
		

		// 동쪽 조립
		p_east.add(ch_top2);
		p_east.add(ch_sub2);
		p_east.add(t_name2);
		p_east.add(t_brand2);
		p_east.add(t_price2);
		p_east.add(bt_find2);
		p_east.add(can2);
		p_east.add(bt_edit);
		p_east.add(bt_del);

		// 스타일적용
		ch_top2.setPreferredSize(new Dimension(135, 30));
		ch_sub2.setPreferredSize(new Dimension(135, 30));
		t_name2.setPreferredSize(new Dimension(135, 30));
		t_brand2.setPreferredSize(new Dimension(135, 30));
		t_price2.setPreferredSize(new Dimension(135, 30));
		can2.setPreferredSize(new Dimension(135, 115));
		bt_find2.setPreferredSize(new Dimension(135, 30));
		bt_edit.setPreferredSize(new Dimension(135, 30));
		bt_del.setPreferredSize(new Dimension(135, 30));

		p_east.setPreferredSize(new Dimension(150, 600));
		// p_east.setBackground(Color.YELLOW);

		// 프레임에 서쪽 영역 붙이기
		add(p_east, BorderLayout.EAST);
		connect();
		getTopList();
		getProductList();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 접속 해제
				disconnect();
				System.exit(0);
			}
		});

		ch_top.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				getSubList(hm.get(ch_top.getSelectedItem()));
			}
		});

		// 파일찾기 버튼과 리스너 연결
		bt_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findImage();
				preview(can);
			}
		});

		// 등록버튼과 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				regist();
				getProductList();
				table.updateUI();
			}
		});

		bt_collect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				collectorFrame = new CollectorFrame(ShoppingApp.this);
			}
		});
		bt_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getSearchResult(ch_category.getSelectedItem(), t_keyword.getText());
				table.updateUI();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				String result = (String)table.getValueAt(row, 0);
				result += "\t"+(String)table.getValueAt(row, 1);
				result += "\t"+(String)table.getValueAt(row, 2);
				result += "\t"+(String)table.getValueAt(row, 3);
				result += "\t"+(String)table.getValueAt(row, 4);
				result += "\t"+(String)table.getValueAt(row, 5);
				System.out.println(result);
				
				getDetail(row);
			}
		});
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// db연동시 하면 안됨..
	}

	// 오라클 접속
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);

			if (con == null) {
				JOptionPane.showMessageDialog(this, "접속 실패");
				System.exit(0);
			} else {
				this.setTitle(user + "로 접속중");
				System.out.println("접속 성공");
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//product 테이블의 레코드 가져오기 
		public void getProductList() {
			String sql="select * from product";
			
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//PreparedStatement 생성시 인수 2개를 넘겨, 전후방향으로 커서를 자유롭게 이동 가능하게할 수 있다. 
				pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//쿼리준비
				rs = pstmt.executeQuery(); //select문 수행 후 결과표를 rs에 대입
				
				//rs의 메서드 중 .getRow() 는 현재 커서의 위치 즉 레코드 어디를 가리키고 있는지를
				//알수 있다..
				
				rs.last();// 커서를 제일 마지막으로 보내기 
				int currentRow = rs.getRow();
				//System.out.println("현재 커서가 가리키는 레코드 번호는 "+currentRow);
				System.out.println("마지막에 도달한 커서의 rowNum "+currentRow);
				
				//rs의 표 데이터를 ProductController가 보유한  data이차원 배열에 대입!!
				String[][] data = new String[currentRow][productController.column.length];
				
				//이차원배열에 데이터를 담으려면, 커서를 다시 원상복귀시켜야 한다..
				rs.beforeFirst(); //첫번째 레코드 보다도 이전으로 되돌림 (즉 위치 초기화)
				
				int index=0;
				while(rs.next()) {
					String[] record = new String[productController.column.length];
					
					record[0] = rs.getString("product_id");
					record[1] = rs.getString("subcategory_id");
					record[2] = rs.getString("product_name");
					record[3] = rs.getString("brand");
					record[4] = rs.getString("price");
					record[5] = rs.getString("filename");
					
					//채워진 일차원 배열을 data 이차원배열에 순서대로 담자
					data[index++]=record;
					System.out.println(index);
				}
				//완성된 이차원배열을 productController가 보유한 data 배열 주소로 대입시켜버리자
				productController.data = data;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
					}
				}
			}
			
		}

	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void getTopList() {
		String sql = "select * from topcategory";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				hm.put(rs.getString("name"), rs.getInt("topcategory_id"));
				ch_top.add(rs.getString("name"));
				ch_top2.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}

	}
	public void getTopList2(int id) {
		ch_top2.removeAll();
		String sql = "select * from topcategory where topcategory_id in(select topcategory_id from subcategory where subcategory_id="+id+")";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ch_top2.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public void getSubList(int id) {
		ch_sub.removeAll();
		ch_sub2.removeAll();
		ch_sub.add("--choose category--");
		ch_sub2.add("--choose category--");
		String sql = "SELECT * FROM SUBCATEGORY WHERE TOPCATEGORY_ID=" + id;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				hm2.put(rs.getString("name"), rs.getInt("subcategory_id"));
				ch_sub.add(rs.getString("name"));
				ch_sub2.add(rs.getString("name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	public void getSubList2(int id) {
		ch_sub2.removeAll();
		String sql = "SELECT * FROM SUBCATEGORY WHERE SUBCATEGORY_ID=" + id;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ch_sub2.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	// 이미지 선택
	public void findImage() {
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			getTargetImage(file.getAbsolutePath());
		}
	}
	public void getTargetImage(String path) {
		img = kit.getImage(path);
		img = ImageUtil.getCustomSize(img, 135, 115);
	}

	// 미리보기
	public void preview(JPanel can) {
		can.repaint();
	}

	public void regist() {
		int subcategory_id = hm2.get(ch_sub.getSelectedItem());
		String product_name = t_name.getText();
		String brand = t_brand.getText();
		int price = Integer.parseInt(t_price.getText());
		String filename = file.getName();
		System.out.println(subcategory_id + "\t" + product_name + "\t" + brand + "\t" + price + "\t" + filename);

		String sql = "insert into product(product_id, subcategory_id, product_name, brand, price, filename) ";
		sql += "values(seq_product.nextval,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		try {
			// 바인드 변수 지정
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, subcategory_id);
			pstmt.setString(2, product_name);
			pstmt.setString(3, brand);
			pstmt.setInt(4, price);
			pstmt.setString(5, filename);
			int result = pstmt.executeUpdate(); // DML의 경우 쿼리로 인한 영향받은 레코드 수를 반환
			if (result == 0) {
				JOptionPane.showMessageDialog(this, "등록 실패");
			} else {
				JOptionPane.showMessageDialog(this, "등록 성공  " + result + " records");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	public void getSearchResult(String category, String keyword) {
		String sql="select * from product where ";
		sql += category+" like '%"+keyword+"%'";
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			//PreparedStatement 생성시 인수 2개를 넘겨, 전후방향으로 커서를 자유롭게 이동 가능하게할 수 있다. 
			pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//쿼리준비
			rs = pstmt.executeQuery(); //select문 수행 후 결과표를 rs에 대입
			
			//rs의 메서드 중 .getRow() 는 현재 커서의 위치 즉 레코드 어디를 가리키고 있는지를
			//알수 있다..
			
			rs.last();// 커서를 제일 마지막으로 보내기 
			int currentRow = rs.getRow();
			//System.out.println("현재 커서가 가리키는 레코드 번호는 "+currentRow);
			System.out.println("마지막에 도달한 커서의 rowNum "+currentRow);
			
			//rs의 표 데이터를 ProductController가 보유한  data이차원 배열에 대입!!
			String[][] data = new String[currentRow][productController.column.length];
			
			//이차원배열에 데이터를 담으려면, 커서를 다시 원상복귀시켜야 한다..
			rs.beforeFirst(); //첫번째 레코드 보다도 이전으로 되돌림 (즉 위치 초기화)
			
			int index=0;
			while(rs.next()) {
				String[] record = new String[productController.column.length];
				
				record[0] = rs.getString("product_id");
				record[1] = rs.getString("subcategory_id");
				record[2] = rs.getString("product_name");
				record[3] = rs.getString("brand");
				record[4] = rs.getString("price");
				record[5] = rs.getString("filename");
				
				//채워진 일차원 배열을 data 이차원배열에 순서대로 담자
				data[index++]=record;
				System.out.println(index);
			}
			//완성된 이차원배열을 productController가 보유한 data 배열 주소로 대입시켜버리자
			productController.data = data;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}
	public void getDetail(int row) {
		t_name2.setText((String)table.getValueAt(row, 2));
		t_brand2.setText((String)table.getValueAt(row, 3));
		t_price2.setText((String)table.getValueAt(row, 4));
		getTargetImage("D:/IT_Korea_Class/Java/project1027/SeProject/res/travel2/"+(String)table.getValueAt(row, 5));
		preview(can2);
		getTopList2(Integer.parseInt(((String)table.getValueAt(row, 1))));
		getSubList2(Integer.parseInt(((String)table.getValueAt(row, 1))));
	}

	public static void main(String[] args) {
		new ShoppingApp();
	}
}
