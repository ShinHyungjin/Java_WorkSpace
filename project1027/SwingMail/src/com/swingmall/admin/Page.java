package com.swingmall.admin;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	private AdminMain adminMain;
	
	public Page(AdminMain adminMain) {
		this.adminMain = adminMain;
		this.setPreferredSize(new Dimension(AdminMain.WIDTH, AdminMain.HEIGHT-100));
	}
	public AdminMain getAdminMain() {
		return adminMain;
	}
}
