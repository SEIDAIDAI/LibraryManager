package com.ibm6.bean;

public class Role {
	private int id;
	private String userId;
	private String userAccount;
	private String userPassword;
	private int  active;
	private int admin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", userId=" + userId + ", userAccount=" + userAccount + ", userPassword="
				+ userPassword + ", active=" + active + ", admin=" + admin + "]";
	}
	
}
