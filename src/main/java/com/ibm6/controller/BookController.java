package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.mapper.BookMapper;
import com.ibm6.model.BookSearchType;
import com.ibm6.service.BookService;

@RestController
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/BookType")
	public List<Book> BookSearchType(@RequestBody Book args)
	{
		List<Book> re = bookService.bookSearchByType(args);
		return re;
	}
	
	@PostMapping("/BookInfo")
	public Book BookInformation(@RequestBody Book args)
	{
		System.out.println(args.getBookId());
		Book re = bookService.showBookInfo(args);
		return re;
	}
	
	@PostMapping("/BookKeyWord")
	public List<Book> BookSearchKeyword(@RequestBody Book book)
	{
		List<Book> re = bookService.bookSearchByKeyword(book);
		return re;
	}
}
