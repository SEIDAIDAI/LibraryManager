package com.ibm6.bean;

import java.util.Date;

public class Borrow {
	private int id;
	private int userId;
	private int bookId;
	private Date borrowTime;
	private Date retTime;
	private int retFlag;
	private int validTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getRetTime() {
		return retTime;
	}
	public void setRetTime(Date retTime) {
		this.retTime = retTime;
	}
	public int getRetFlag() {
		return retFlag;
	}
	public void setRetFlag(int retFlag) {
		this.retFlag = retFlag;
	}
	public int getValidTime() {
		return validTime;
	}
	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", borrowTime=" + borrowTime
				+ ", retTime=" + retTime + ", retFlag=" + retFlag + ", validTime=" + validTime + "]";
	}
	
}
