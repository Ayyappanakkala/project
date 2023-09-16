package com.authentication;

public class Login {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//default constructor
	public Login() {
		super();
		
	}
	//constructor with paramters
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
