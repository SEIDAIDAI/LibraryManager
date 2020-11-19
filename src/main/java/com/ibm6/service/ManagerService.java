package com.ibm6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Book;
import com.ibm6.mapper.BookMapper;

@Service
public class ManagerService {
	
	@Autowired
	private BookMapper bookMapper;
//	private manager
	public Book findBookById(Book book) {
		return bookMapper.getById(book);
	}
}
