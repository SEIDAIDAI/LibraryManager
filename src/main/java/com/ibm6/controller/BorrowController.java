package com.ibm6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm6.bean.Borrow;
import com.ibm6.model.BorrowBookInfo;
import com.ibm6.model.BorrowByPage;
import com.ibm6.model.BorrowDetail;
import com.ibm6.model.BorrowList;
import com.ibm6.model.UserBorrowLikeSearch;
import com.ibm6.service.borrowService;

@RestController
public class BorrowController {
	@Autowired
	private borrowService service;

	// 功能: 查看某一本书的详情
	// 输入参数 : id(借阅条目的id borrow id)
	// 返回结果: 浮动栏显示这本书的借阅详情
	/*
	 * String bookName; 
	 * Date borrowTime; 
	 * Date retTime;
	 * int validTime;
	 */
	@GetMapping("/borrowInfo/{id}")
	public BorrowDetail borrowHistory(@PathVariable("id") int id) {
		BorrowDetail borrow = service.getBorrowInfo(id);
		return borrow;
	}

	// 功能: 用户书架  查询用户借阅
	// 输入参数 : userId
	// 返回结果: 
	/*
	 * String bookName; 
	 * Date borrowTime; 
	 * Date retTime;
	 * int validTime;
	 */
	@GetMapping("/borrowList/{userId}")
	public List<BorrowList> borrowBookInfo(@PathVariable("userId") int userId) {
		List<BorrowList> borrow = service.getBorrowList(userId);
		return borrow;
	}
	
	@GetMapping("/borrowUserShelf/{userId}")
	public List<BorrowBookInfo> borrowBookShelf(@PathVariable("userId") int userId) {
		List<BorrowBookInfo> borrow = service.getBorrowShelf(userId);
		return borrow;
	}

	//在上面查询的结果上 加上书名进行过滤
	// 功能: 根据书名过滤借阅历史
	// 输入参数 : userId  bookName
	// 返回结果: 浮动栏显示这本书的借阅详情
	/*
	 * String bookName; 
	 * Date borrowTime; 
	 * Date retTime;
	 * int validTime;
	 */
	@PostMapping("/borrowUserLikeSearch")
	public List<BorrowBookInfo> searchHisByLikeSearch(@RequestBody UserBorrowLikeSearch userBorrowLikeSearch) {
		List<BorrowBookInfo> borrowDetail = service.borrowUserLikeSearch(userBorrowLikeSearch);
		return borrowDetail;
	}

	// 功能: 用户借阅历史的总数
	// 输入参数 : userId
	// 返回结果: int
	@GetMapping("/borrowCount/{userId}")
	public int BorrowCount(@PathVariable("userId") int userId) {
		int re = service.getBorrowTotal(userId);
		return re;
	}

	/* 已修改完成 */
	// 功能: 用户借阅列表的分页查询
	// 输入参数 : userId index(页数)
	// 返回结果: 分页显示用户的借阅书列表
	/*
	 * int id;  
	 * String bookName;  
	 * String nation; 
	 * String theme; 
	 * String type;  
	 * String length;  
	 * Date borrowTime;
	 */
	@PostMapping("/borrowPage")
	public List<BorrowBookInfo> BorrowPage(@RequestBody BorrowByPage borrowByPage) {
		List<BorrowBookInfo> re = service.getBorrowByPage(borrowByPage);
		return re;
	}
	
	
	//功能: 用户进行图书借阅
	//输入参数  
	/*
	 * int userId; 
	 * int bookId; 
	 */
	//返回结果 int  1表示借阅成功     0表示借阅失败    2 表示这本书用户已借阅    3没有库存
	@PostMapping("/borrowBook")
	public int BorrowBook(@RequestBody Borrow borrow)
	{
		int re = service.borrowBook(borrow);
		return re;
	}
	

	//功能: 用户借阅书籍归还
	//输入参数:  userId  bookId
	//输出参数: int  1表示成功  0表示成功
	@PostMapping("/borrowReturn")
	public int BorrowReturn(@RequestBody Borrow borrow)
	{
		//需要修改用户的借阅记录  ret_flag修改为 0 
		//需要修改书籍的数量 left_amount 增加 1
		int re = service.borrowReturn(borrow);
		return re;
	}
	
	//统计功能  年月日  	
}
