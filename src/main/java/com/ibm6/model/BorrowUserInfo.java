package com.ibm6.model;

import java.util.Date;

public class BorrowUserInfo {
	private int id;
	private String bookName;
	private String nation;
	private String theme;
	private String type;
	private String length;
	private Date retTime;
	private int bookId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}

	public Date getRetTime() {
		return retTime;
	}
	public void setRetTime(Date retTime) {
		this.retTime = retTime;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}