package com.ibm6.bean;

public class Role {
<<<<<<< HEAD
	private int roleId;
=======
	private int id;
>>>>>>> 5a2f70a0706f8b73ab75dc5e4c816a7768e5dd11
	private int userId;
	private String userAccount;
	private String userPassword;
	private int  active;
	private int admin;
<<<<<<< HEAD
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
=======
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
>>>>>>> 5a2f70a0706f8b73ab75dc5e4c816a7768e5dd11
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
<<<<<<< HEAD
=======
	@Override
	public String toString() {
		return "Role [id=" + id + ", userId=" + userId + ", userAccount=" + userAccount + ", userPassword="
				+ userPassword + ", active=" + active + ", admin=" + admin + "]";
	}
>>>>>>> 5a2f70a0706f8b73ab75dc5e4c816a7768e5dd11
	
}
