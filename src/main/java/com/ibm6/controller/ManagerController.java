package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;
import com.ibm6.model.BookUserList;
import com.ibm6.model.BooksInfo;
import com.ibm6.model.BorrowBookInfo;
import com.ibm6.model.UserAndAccount;
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
	
	//功能：分页显示管理员页面的所有图书
	//输入参数： 页号
	//返回参数: List<Book>
	
	@GetMapping("/managerBookByPage/{index}")
	public List<Book> bookByPage(@PathVariable("index") Integer index){
		List<Book> books = bookService.bookSearchByPage(index*5);
		return books;
	}
	
	//功能: 显示所有书籍总数
	//输入参数： 无
	//输出参数： int
	@RequestMapping("/managerBookCount")
	public int bookCount(){
		int re = bookService.totalBookAmount();
		return re;
	}
	
	
	//功能: 根据书id查询书籍详情
	//输入参数: bookId
	//输出参数: Book
	@RequestMapping("/managerFindBookById/{bookId}")
	public Book findBookById(@PathVariable("bookId") Integer bookId) {
		Book book = new Book();
		book.setBookId(bookId);
		return managerService.findBookById(book);
	}
	
	//功能：注销用户
	//输入参数:  userId
	//输出参数:  1成功 ；   0书没还完，注销失败；   -1删除失败
	@RequestMapping("/managerDeleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		List<BorrowBookInfo> borrowShelf = borrowService.getBorrowShelf(userId);
//		for(BorrowBookInfo b:borrowShelf) {
//			System.out.println(b.getBookId());
//		}
		System.out.println(borrowShelf.size());
		
		
		if (borrowShelf.get(0).getBookId()!=0) {
			return "0";
		}
		if (managerService.deleteUser(userId)==1) {
			return "1";
		}
		return "-1";
	}
	
	//管理员查询所有用户
	@RequestMapping("/ManagerShowUserList/{index}")
	public List<UserAndAccount> showUserList(@PathVariable("index") Integer index){
		return managerService.findUserByPage(index * 5);
	}
	
	//不使用  统一用bookType
	@RequestMapping("/managerFindBookByCondition/{index}")
	public List<Book> managerFindBookByCondition(
			@RequestBody Book book,
			@PathVariable("index") Integer index){
		return bookService.bookSearchByKeyword(book, index*5);
	}
	
	//管理员的书库功能
	@RequestMapping("/managerFindBookByType/{index}")
	public List<Book> managerFindBookByType(
			@RequestBody Book book,
			@PathVariable("index") Integer index){
		System.out.println(book);
		return bookService.bookSearchByType(book, index*5);
	}
	
	//管理员点击某本书的借阅详情按钮，显示历史借阅的用户
	@GetMapping("/managerBookUserList/{bookId}")
	public List<BookUserList> managerBookUserList(@PathVariable("bookId") Integer bookId)
	{
		return bookService.bookUserList(bookId);   
	}
}
