package com.ibm6.model;

public class registModel {
	private String account;
	private String password;
	private String name;
	private String email;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "registModel [account=" + account + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	
}
