package com.ibm6.mapper;

import java.util.List;

import com.ibm6.bean.Book;

public interface BookMapper {
	public List<Book> findByCondition(Book book);
	public Book findById(Book book);
	public List<Book> findByKeyword(Book book);  //统一传给书名
}
