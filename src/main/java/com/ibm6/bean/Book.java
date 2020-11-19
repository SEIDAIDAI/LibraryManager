package com.ibm6.bean;

import java.util.Date;

public class Book {
	private int bookId;
	private String bookName;
	private String nation;
	private String type;
	private String length;
	private String theme;
	private Date storeDate;
	private int leftAmount;
	private int uploadAmount;
	private int downloadAmount;
	private String author;

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
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Date getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(Date storeDate) {
		this.storeDate = storeDate;
	}
	public int getLeftAmount() {
		return leftAmount;
	}
	public void setLeftAmount(int leftAmount) {
		this.leftAmount = leftAmount;
	}
	public int getUploadAmount() {
		return uploadAmount;
	}
	public void setUploadAmount(int uploadAmount) {
		this.uploadAmount = uploadAmount;
	}
	public int getDownloadAmount() {
		return downloadAmount;
	}
	public void setDownloadAmount(int downloadAmount) {
		this.downloadAmount = downloadAmount;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", nation=" + nation + ", type=" + type
				+ ", length=" + length + ", theme=" + theme + ", storeDate=" + storeDate + ", leftAmount=" + leftAmount
				+ ", uploadAmount=" + uploadAmount + ", downloadAmount=" + downloadAmount + "]";
	}
	
}
