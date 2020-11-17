package com.ibm6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm6.bean.Book;
import com.ibm6.mapper.BookMapper;
import com.ibm6.model.BookSearchType;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private Book book;
		
	public int bookSearchByType(BookSearchType args) {
		
		if (args.getNation() != null){
			book.setNation(args.getNation());
		}
		if (args.getType() != null) {
			book.setType(args.getType());
		}
		if (args.getLength() != null) {
			book.setLength(args.getLength());
		}	
		if (args.getTheme() != null)
		{
			book.setTheme(args.getTheme());
		}
		int re = bookMapper.findByCondition(book);
		
		return re;
	}
}
