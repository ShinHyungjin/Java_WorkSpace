package com.swingmall.member;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class RegistForm extends Page{
	JPanel p_content; //로그인폼과 동일한 목적으로 ...
	JTextField t_mid;
	JPasswordField t_pass;
	JTextField t_name;
	JTextField t_phone;
	JTextField t_email;
	JButton bt_regist;
	
	public RegistForm(ShopMain shopMain) {
		super(shopMain);
		p_content = new JPanel();
		
		t_mid = new JTextField("ID");
		t_pass = new JPasswordField("PASS");
		t_name = new JTextField("NAME");
		t_phone = new JTextField("PHONE");
		t_email = new JTextField("E-MAIL");
		bt_regist = new JButton("회원가입");
		
		//스타일 
		p_content.setPreferredSize(new Dimension(400, 350));
		p_content.setBackground(Color.WHITE);
		Dimension d = new Dimension(380,25);
		t_mid.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_phone.setPreferredSize(d);
		t_email.setPreferredSize(d);
		
		//조립 
		p_content.add(t_mid);
		p_content.add(t_pass);
		p_content.add(t_name);
		p_content.add(t_phone);
		p_content.add(t_email);
		p_content.add(bt_regist);
		
		add(p_content);
		
		bt_regist.addActionListener((e) ->  {
			if(checkId(t_mid.getText())) // 회원가입시 id 중복조회
				JOptionPane.showMessageDialog(this, "중복된 아이디!");
			else {
				ShopMember vo = new ShopMember();
				vo.setMid(t_mid.getText());
				vo.setPass(new String(t_pass.getPassword()));
				vo.setName(t_name.getText());
				vo.setPhone(t_phone.getText());
				vo.setEmail(t_email.getText());
				if(regist(vo)==0)
					JOptionPane.showMessageDialog(this, "가입실패");
				else
					JOptionPane.showMessageDialog(this, "가입성공");
			}
				
		});
	}
	public int regist(ShopMember shopMember) {
		PreparedStatement pstmt = null;
		String sql = "insert into shop_member(member_id, mid,pass,name,phone,email) ";
		sql += "values(seq_shop_member.nextval,?,?,?,?,?)";
		
		int result=0;
		
		try {
			pstmt = getShopMain().getCon().prepareStatement(sql);
			
			pstmt.setString(1, shopMember.getMid());
			pstmt.setString(2, shopMember.getPass());
			pstmt.setString(3, shopMember.getName());
			pstmt.setString(4, shopMember.getPhone());
			pstmt.setString(5, shopMember.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getShopMain().getDbManager().close(pstmt);
		}
		return result;
	}
	
	public boolean checkId(String mid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from shop_member where mid=?";
		boolean flag = false;
		try {
		pstmt = getShopMain().getCon().prepareStatement(sql);
		pstmt.setString(1, mid);
		rs = pstmt.executeQuery();
		
		flag = rs.next();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			getShopMain().getDbManager().close(pstmt,rs);
		}
		return flag;
	}
	
}