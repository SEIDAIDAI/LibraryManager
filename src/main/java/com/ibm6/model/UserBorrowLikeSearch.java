package com.ibm6.model;

import java.util.Date;

public class UserBorrowLikeSearch {
	private int index;
	private int userId;
	private String bookName;
	private Date retTime;
	public final Date getRetTime() {
		return retTime;
	}
	public final void setRetTime(Date retTime) {
		this.retTime = retTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
