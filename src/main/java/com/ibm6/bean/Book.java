package com.ibm6.bean;

<<<<<<< HEAD
import java.util.Date;

=======
>>>>>>> 5a2f70a0706f8b73ab75dc5e4c816a7768e5dd11
public class Book {
	private int bookId;
	private String bookName;
	private String nation;
	private String type;
	private String length;
	private String theme;
<<<<<<< HEAD
	private Date storeDate;
=======
	private String storeDate;
>>>>>>> 5a2f70a0706f8b73ab75dc5e4c816a7768e5dd11
	private int leftAmount;
	private int uploadAmount;
	private int downloadAmount;
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
<<<<<<< HEAD
	public Date getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(Date storeDate) {
=======
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
>>>>>>> 5a2f70a0706f8b73ab75dc5e4c816a7768e5dd11
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
	
}
