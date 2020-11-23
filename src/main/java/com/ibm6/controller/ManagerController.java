package com.ibm6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Book;
import com.ibm6.bean.User;
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
	
	//功能：分页显示管理员页面的所有图书
	//输入参数： 页号
	//返回参数: List<Book>
	@RequestMapping("/managerBookByPage/{index}")
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
	//输出参数: int  1成功    0失败
	@RequestMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		if (managerService.deleteUser(userId)==1) {
			return "1";
		}
		return "0";
	}
	
	
	@RequestMapping("/ManagerShowUserList/{index}")
	public List<User> showUserList(@PathVariable("index") Integer index){
		return managerService.findUserByPage(index * 5);
	}
}
