package com.ibm6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.mapper.BookMapper;
import com.ibm6.model.BookSearchType;
import com.ibm6.service.BookService;

@RestController
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/BookSearch")
	public void BookSearchType(@RequestBody BookSearchType args)
	{
		int re = bookService.bookSearchByType(args);
	}
}
