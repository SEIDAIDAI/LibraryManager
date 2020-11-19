package com.ibm6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.model.BookLength;
import com.ibm6.model.BookNation;
import com.ibm6.model.BookStatus;
import com.ibm6.model.BookTheme;
import com.ibm6.model.BookType;
import com.ibm6.model.BorrowList;
import com.ibm6.service.BookService;
import com.ibm6.service.borrowService;

@RestController
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private borrowService borrowService;
	
	@PostMapping("/BookCount")
	public int bookCount()
	{
		int re = bookService.totalBookAmount();
		return re;
	}
	
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
		System.out.println(book.getBookId());
		System.out.println(book);
		List<Book> re = bookService.bookSearchByKeyword(book);
		return re;
	}
	
	@GetMapping("/BookByPage/{index}")
	public List<Book> BookSearchPage(@PathVariable("index") Integer index)
	{
		List<Book> re = bookService.bookSearchByPage(index * 5);
		return re;
	}
	
	@PostMapping("/BookInfoUpdate")
	public int BookInfoUpdate(@RequestBody Book book)
	{
		int re = bookService.bookInfoUpdate(book);
		return re;
	}

	@PostMapping("/BookInsert")
	public int BookInsert(@RequestBody Book book)
	{
		int re = bookService.bookInsert(book);
		return re;
	}
	
	@PostMapping("/BookDelete")
	public int BookDelete(@RequestBody Book book)
	{
		int re = bookService.bookDelete(book);
		return re;
	}
	
//	@PostMapping("/BookStatus")
//	public int BookDStatus(@RequestBody Book book)
//	{
//		int re = bookService.bookDelete(book);
//		return re;
//	}
	
	@GetMapping("/bookNation")
	public List<BookNation> bookNations(){
		List<BookNation> re = bookService.bookNations();
		return re;
	}
	
	@GetMapping("/bookType")
	public List<BookType> bookTypes(){
		return bookService.bookTypes();
	}
	
	@GetMapping("/bookTheme/{bookType}")
	public List<BookTheme> bookThemes(@PathVariable() int bookType){
		return bookService.bookThemes(bookType);
	}
	
	
	@GetMapping("/bookLength")
	public List<BookLength> bookLengths(){
		return bookService.bookLengths();
	}
	
	
	@RequestMapping("/bookStatus/{index}/{userId}")
	public List<BookStatus> bookStatus(@PathVariable("index") Integer index,@PathVariable("userId") Integer userId){
		List<Book> books = bookService.bookSearchByPage(index*5);
		List<Integer> mybooks=new ArrayList<Integer>();
		List<BorrowList> borrowList = borrowService.getBorrowList(userId);
		for(BorrowList bl:borrowList) {
			mybooks.add(bl.getBookId());
		}
		List<BookStatus> bookStatuses=new ArrayList<BookStatus>();
		for(Book bs:books) {
			BookStatus temp=new BookStatus();
			for(Integer i:mybooks) {
				if (i==bs.getBookId()) {
					temp.setStatus(1);
				}else {
					temp.setStatus(0);
				}
			}
			temp.setBook(bs);
			bookStatuses.add(temp);
		}
		return bookStatuses;
		
	}
	
}
