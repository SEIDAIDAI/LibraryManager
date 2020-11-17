package com.ibm6.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Book;
import com.ibm6.mapper.BookMapper;
import com.ibm6.model.BookSearchType;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
		
	public List<Book> bookSearchByType(Book book) {
		List<Book> bookList = bookMapper.findByCondition(book);

		return bookList;
	}
	
	public Book showBookInfo(Book book) {
		Book re = bookMapper.findById(book);
		return re;
	}
	
	public List<Book> bookSearchByKeyword(Book book)
	{
		List<Book> bookList = bookMapper.findByKeyword(book);

		return bookList;
	}
	
}
