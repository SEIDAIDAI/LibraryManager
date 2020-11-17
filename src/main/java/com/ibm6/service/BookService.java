package com.ibm6.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;
import com.ibm6.mapper.BookMapper;
import com.ibm6.mapper.UserMapper;
import com.ibm6.model.BookSearchType;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	private UserMapper userMapper;
		
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
	
	public List<Book> bookSearchByPage(Integer index)
	{
		List<Book> bookList = bookMapper.findByPage(index);

		return bookList;
	}
	
	public int bookInfoUpdate(Book book)
	{
		int re = bookMapper.updateById(book);

		return re;
	}
	
	/*
	 * public List<User> UserSearch(int index) { List<User> re =
	 * userMapper.selectById(index); }
	 */
}




