package com.ibm6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm6.bean.Book;
import com.ibm6.mapper.BookMapper;

public class BookController {
	@Autowired
	private Book book;
	
	@Autowired
	private BookMapper bookMapper;
	
	@RequestMapping("/BookSearchType")
	public void BookSearchType(BookSearchType args)
	{
		if (args.nation != null){
			book.setNation(args.nation);
		}
		if (args.type != null) {
			book.setType(args.type);
		}
		if (args.length != null) {
			book.setLength(args.length);
		}	
		if (args.theme != null)
		{
			book.setTheme(args.theme);
		}
		
	}
}
