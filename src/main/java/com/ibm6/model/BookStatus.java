package com.ibm6.model;

import com.ibm6.bean.Book;

public class BookStatus {
	private Book book;
	private int status;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookStatus [book=" + book + ", status=" + status + "]";
	}
	
}
