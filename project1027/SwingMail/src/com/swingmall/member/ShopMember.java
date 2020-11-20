package com.swingmall.member;

public class ShopMember {
	int member_id;
	String mid;
	String pass;
	String name;
	String phone;
	String email;
	
	/*
	 * public ShopMember(String member_id, String mid, String pass, String name,
	 * String phone, String email) { this.memer_id = member_id; this.mid = mid;
	 * this.pass = pass; this.name = name; this.phone = phone; this.email = email; }
	 */
	public ShopMember() {
	
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int memer_id) {
		this.member_id = memer_id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
