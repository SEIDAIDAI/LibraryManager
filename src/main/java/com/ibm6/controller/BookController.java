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
	
	//功能: 返回 默认输出全部书时的书总数
	//输入参数：无
	//输出参数：int
	@PostMapping("/BookCount")
	public int bookCount()
	{
		int re = bookService.totalBookAmount();
		return re;
	}
	
	//功能: 返回 查询某些类型书时的总数
	//输入参数: 无
	//输出参数: int
	@PostMapping("/BookTypeCount")
	public int bookTypeCount(@RequestBody Book book)
	{
		int re = bookService.bookTotalByType(book);
		return re;
	}
	
	//能否把含有bookName的作者或者含有bookName的书都查询出来
	//功能：模糊查询用户书籍，并分页显示
	//输入参数：book 存放模糊查询条件    userId  index(页号)
	//输出参数: 返回符合结果的书籍, 带有书籍的借阅状态
	@PostMapping("/BookType/{userId}/{index}")
	public List<BookStatus> BookSearchType(
			@RequestBody Book args,
			@PathVariable("index") Integer index,
			@PathVariable("userId") Integer userId){
		List<Book> books = bookService.bookSearchByType(args,index*5);
		List<Integer> mybooks=new ArrayList<Integer>();
		List<BorrowList> borrowList = borrowService.getBorrowList(userId);
		System.out.println(borrowList);
		for(BorrowList bl:borrowList) {
			System.out.println(bl.getBookId());
			mybooks.add(bl.getBookId());
		}
		List<BookStatus> bookStatuses=new ArrayList<BookStatus>();
		for(Book bs:books) {
			BookStatus temp=new BookStatus();
			for(Integer i:mybooks) {
				if (i==bs.getBookId()) {
					temp.setStatus(1);
					break;
				}else {
					temp.setStatus(0);
				}
				
			}
			temp.setBook(bs);
			bookStatuses.add(temp);
		}
		return bookStatuses;
	}
	
	//功能: 显示书籍详情
	//输入参数: bookId
	//输出参数： Book
	@PostMapping("/BookInfo")
	public Book BookInformation(@RequestBody Book args)
	{
		Book re = bookService.showBookInfo(args);
		return re;
	}
	
	//功能： 返回关键字查询结果的总条数
	//输入参数： Book 把条件放在里面  条件有  bookName  author  nation type theme length
	//输出参数： int 返回符合条件的所有书的条数
	@PostMapping("/BookKeyWordCount")
	public int BookKeyWordCount(@RequestBody Book book)
	{
		int re = bookService.BookTotalByKeyword(book);
		return re;
	}
	
	//功能：用户借阅的书籍，书籍带有状态
	@PostMapping("/BookKeyWord/{userId}/{index}")
	public List<BookStatus> BookSearchKeyword(
			@RequestBody Book book,
			@PathVariable("index") Integer index,
			@PathVariable("userId") Integer userId){
		List<Book> books = bookService.bookSearchByKeyword(book,index*5);
		return addMyStatus(books, userId);
	}
	
	//分页显示全部书籍 不带有状态
	@GetMapping("/BookByPage/{index}")
	public List<Book> BookSearchPage(@PathVariable("index") Integer index)
	{
		List<Book> re = bookService.bookSearchByPage(index * 5);
		return re;
	}
	
	//更新图书信息
	@PostMapping("/BookInfoUpdate")
	public int BookInfoUpdate(@RequestBody Book book)
	{
		int re = bookService.bookInfoUpdate(book);
		return re;
	}

	//新增图书
	@PostMapping("/BookInsert")
	public int BookInsert(@RequestBody Book book)
	{
		if(bookService.findByBook(book)!=null) {
			return -1;
		}
		int re = bookService.bookInsert(book);
			
		return re;
	}
	
	//删除图书
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
	
	//返回所有国家
	@GetMapping("/bookNation")
	public List<BookNation> bookNations(){
		List<BookNation> re = bookService.bookNations();
		return re;
	}
	
	//返回书的所有种类
	@GetMapping("/bookType")
	public List<BookType> bookTypes(){
		return bookService.bookTypes();
	}
	
	//返回某种类下的所有主题
	@GetMapping("/bookTheme/{bookType}")
	public List<BookTheme> bookThemes(@PathVariable() int bookType){
		return bookService.bookThemes(bookType);
	}
	
	//返回所有篇幅
	@GetMapping("/bookLength")
	public List<BookLength> bookLengths(){
		return bookService.bookLengths();
	}
	
	//
	@RequestMapping("/bookStatus/{index}/{userId}")
	public List<BookStatus> bookStatus(
			@PathVariable("index") Integer index,
			@PathVariable("userId") Integer userId){
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
					break;
				}else {
					temp.setStatus(0);
				}
			}
			temp.setBook(bs);
			bookStatuses.add(temp);
		}
		return bookStatuses;
		
	}
	
	
//	@RequestMapping("/findByAu")
//	@RequestMapping("/findBookByFourCondition/{index}")
//	public List<BookStatus> findBookByFourCondition(@RequestBody Book book,@PathVariable Integer index){
//		bookService.bookSearchByType(book);
//		
//		return null;
//	}
	 private List<BookStatus> addMyStatus(List<Book> books,Integer userId){
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
						break;
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
