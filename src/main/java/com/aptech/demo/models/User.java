package com.aptech.demo.models;

public class User {
	
	private String user_id;
	private String usertype;
	private String name;
	private String password;
	private String email;
	private String tel;
	private String address;
	private String role;
	private int user_active;
	
	public User() {
		super();
	}

	public User(String user_id, String usertype, String name, String password, String email, String tel, String address,
			String role, int user_active) {
		super();
		this.user_id = user_id;
		this.usertype = usertype;
		this.name = name;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.role = role;
		this.user_active = user_active;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUser_active() {
		return user_active;
	}

	public void setUser_active(int user_active) {
		this.user_active = user_active;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", password=" + password + ", email=" + email + ", tel="
				+ tel + ", address=" + address + ", role=" + role + ", user_active=" + user_active + "]";
	}
	
	
}
