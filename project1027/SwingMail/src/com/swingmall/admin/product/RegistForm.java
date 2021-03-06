/*
 * 상품등록 폼을 정의한다!!
 * */
package com.swingmall.admin.product;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.swingmall.admin.AdminMain;

public class RegistForm extends JPanel{
	Product product;
	JPanel p_container;//그리드 적용 예정(7, 2)

	String[] title= {"상위카테고리","하위카테고리","상품명","브랜드","가격","이미지","상세설명"};
	JLabel[] la_title = new JLabel[title.length];
	
	Choice ch_top;//최상위 카테고리
	Choice ch_sub;//하위 카테고리
	JTextField t_product_name;//상품명
	JTextField t_brand;//브랜드
	JTextField t_price;//가격
	JTextField t_filename;//이미지
	JTextArea t_detail;//상세설명
	JScrollPane s1; //상세설명에 부착할 스크롤
	JButton bt_regist;
	JButton bt_list;
	
	public RegistForm(Product product) {
		this.product=product;
		p_container = new JPanel();
		for(int i=0;i<title.length;i++) {
			la_title[i] = new JLabel(title[i], SwingConstants.RIGHT);
		}
		ch_top = new Choice();
		ch_sub = new Choice();
		t_product_name = new JTextField();
		t_brand = new JTextField();
		t_price = new JTextField();
		t_filename = new JTextField();
		t_detail = new JTextArea();
		s1 = new JScrollPane(t_detail);
		bt_regist = new JButton("등록");
		bt_list = new JButton("목록");
		
		//최상위 카테고리 채우기(DB연동X, 기존데이터 재사용하자)
		for(String name:product.topList) {
			ch_top.add(name);
		}
		
		
		//스타일 적용 
		Dimension d = new Dimension(320,25);
		
		p_container.setBackground(Color.WHITE);
		p_container.setPreferredSize(new Dimension(AdminMain.WIDTH-500, AdminMain.HEIGHT-400));
		for(int i=0;i<title.length;i++) {
			la_title[i].setPreferredSize(d);
		}
		ch_top.setPreferredSize(d);
		ch_sub.setPreferredSize(d);
		t_product_name.setPreferredSize(d);
		t_brand.setPreferredSize(d);
		t_price.setPreferredSize(d);
		t_filename.setPreferredSize(d);
		t_detail.setPreferredSize(new Dimension(320, 300));
		bt_regist.setPreferredSize(new Dimension(300, 40));
		bt_list.setPreferredSize(new Dimension(300, 40));
		
		//조립
		p_container.add(la_title[0]);
		p_container.add(ch_top);
		p_container.add(la_title[1]);
		p_container.add(ch_sub);
		p_container.add(la_title[2]);
		p_container.add(t_product_name);
		p_container.add(la_title[3]);
		p_container.add(t_brand);
		p_container.add(la_title[4]);
		p_container.add(t_price);
		p_container.add(la_title[5]);
		p_container.add(t_filename);
		p_container.add(la_title[6]);
		p_container.add(s1);
		
		this.add(p_container);//현재 패널에 폼컨테이너 부착
		this.add(bt_regist);//현재 패널에 버튼 부착
		this.add(bt_list);//현재 패널에 버튼 부착
		
		bt_regist.addActionListener((e)->{
			if(regist()==0) {
				JOptionPane.showMessageDialog(this, "데이터 삽입 실패!");
			} else {
				JOptionPane.showMessageDialog(this, "데이터 삽입 완료!");
				product.getProductList(null);
			}
		});
		
		//목록으로 돌아가기
		bt_list.addActionListener((e)->{
			product.addRemoveContent(this, product.p_center);
		});
		
		ch_top.addItemListener((e)->{
			System.out.println("나 바꿨어?");
			getSubCategory(ch_top.getSelectedIndex());
		});
	}
	
	//지금 유저가 선택한 최상위 카테고리에 소속된 하위카테고리만 가져오기!!
	public void getSubCategory(int index) {
		ArrayList<String> list = product.subList.get(index);
		
		ch_sub.removeAll();//채워넣기 전에, 기존 아이템들은 삭제...
		
		for(String item: list) {
			ch_sub.add(item);
		}
	}
	
	public int getSubId(String name) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int subcategory_id = 0;
		
		String sql = "select * from subcategory where name=?";
		try {
			pstmt = product.getAdminMain().getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				subcategory_id = rs.getInt("subcategory_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			product.getAdminMain().getDbManager().close(pstmt,rs);
		}
		
		return subcategory_id;
	}
	
	public int regist() {
		PreparedStatement pstmt=null;
		String sql = "insert into product(product_id, subcategory_id, product_name, brand, price, filename, detail) ";
		sql += "values(seq_product.nextval, ?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = product.getAdminMain().getCon().prepareStatement(sql);
			
			pstmt.setInt(1, getSubId(ch_sub.getSelectedItem()));
			pstmt.setString(2, t_product_name.getText());
			pstmt.setString(3, t_brand.getText());
			pstmt.setInt(4, Integer.parseInt(t_price.getText()));
			pstmt.setString(5, t_filename.getText());
			pstmt.setString(6, t_detail.getText());
			
			result = pstmt.executeUpdate(); // DML			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			product.getAdminMain().getDbManager().close(pstmt);
		}
		return result;
	}
}