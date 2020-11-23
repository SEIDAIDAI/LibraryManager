package com.ibm6.model;

import java.util.Date;

public class BorrowList {
	private int id;
	private String author;
	private int bookId;
	private String bookName;
	private String summary;
	private Date retTime;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getRetTime() {
		return retTime;
	}
	public void setRetTime(Date retTime) {
		this.retTime = retTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BorrowList [id=" + id + ", author=" + author + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", summary=" + summary + ", retTime=" + retTime + "]";
	}
	
	
	
}
