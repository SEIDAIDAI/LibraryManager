package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.model.BooksInfo;
import com.ibm6.service.BookService;
import com.ibm6.service.ManagerService;
import com.ibm6.service.borrowService;

@RestController
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private borrowService borrowService;
	
	@Autowired
	private BookService bookService;
	
	//管理员页面的图书详情
	@RequestMapping("/managerBookByPage/{index}")
	public List<Book> bookByPage(@PathVariable("index") Integer index){
		List<Book> books = bookService.bookSearchByPage(index*5);
		return books;
	}
	
	@RequestMapping("/managerBookCount")
	public int bookCount(){
		int re = bookService.totalBookAmount();
		return re;
	}
	
	
	
	@RequestMapping("/managerFindBookById/{bookId}")
	public Book findBookById(@PathVariable("bookId") Integer bookId) {
		
		Book book = new Book();
		book.setBookId(bookId);
		return managerService.findBookById(book);
	}
	
	@RequestMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {

		if (managerService.deleteUser(userId)==1) {
			return "1";
		}
		
		return "0";
		
	}
}
