package com.example.springbootjpademo.entity;

/**
 * @author wangning
 * @create 2021-01-08 11:25
 */
public class User {
	private int id;
	private String username;
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
