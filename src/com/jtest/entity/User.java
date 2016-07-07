package com.jtest.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String userName;
	private String password;
	private String realName;

	public User() {
	}

	public User(int id, String userName, String password, String realName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
