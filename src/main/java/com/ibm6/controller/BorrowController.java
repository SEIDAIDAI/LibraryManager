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
import com.ibm6.model.BorrowUserInfo;
import com.ibm6.model.FiveMonthData;
import com.ibm6.model.UserBorrowLikeSearch;
import com.ibm6.model.UserNameAndTotalNum;
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
		userBorrowLikeSearch.setIndex(userBorrowLikeSearch.getIndex()*5);
		List<BorrowBookInfo> borrowDetail = service.borrowUserLikeSearch(userBorrowLikeSearch);

		return borrowDetail;
	}
	
	
	@PostMapping("/borrowUserLikeSearchCount")
	public int searchHisByLikeSearchCount(@RequestBody UserBorrowLikeSearch userBorrowLikeSearch) {
		System.out.println(userBorrowLikeSearch);
		int re = service.borrowUserLikeSearchCount(userBorrowLikeSearch);
		
		return re;
	}

	// 功能: 用户借阅历史的总数
	// 输入参数 : userId
	// 返回结果: int
	@GetMapping("/borrowCount/{userId}")
	public UserNameAndTotalNum BorrowCount(@PathVariable("userId") int userId) {
		UserNameAndTotalNum re = new UserNameAndTotalNum();
		re = service.getBorrowTotalAndName(userId);
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
	public List<BorrowUserInfo> BorrowPage(@RequestBody BorrowByPage borrowByPage) 
	{
		List<BorrowUserInfo> re = service.getBorrowByPage(borrowByPage);
		System.out.println(re.get(0).getRetTime());
		return re;
	}
	
	
	//功能: 用户进行图书借阅
	//输入参数  
	/*
	 * int userId; 
	 * int bookId; 
	 */
	//返回结果 int  1表示借阅成功     0表示借阅失败     2 表示这本书用户已借阅     3表示用户已借阅了3本书，不能再借阅，   4没有库存
	//并发控制 -----------------------多人借书
	@PostMapping("/borrowBook")
	public int BorrowBook(@RequestBody Borrow borrow)
	{
		int re = service.borrowBook(borrow);
		return re;
	}
	

	//功能: 用户借阅书籍归还
	//输入参数:  id 借阅id  bookId 书id
	//输出参数: int  1表示成功     0表示失败    2表示用户并没有借阅这本书
	//并发控制---------------------------多人还书
	@PostMapping("/borrowReturn")
	public int BorrowReturn(@RequestBody Borrow borrow)
	{
		//需要修改用户的借阅记录  ret_flag修改为 0 
		//需要修改书籍的数量 left_amount 增加 1
		
		//先检查记录是否存在
		//存在才进行删除
		int re = service.borrowReturn(borrow);
		return re;
	}
	
	
	//统计功能  年月日  
	//功能: 当日借出量
	//输入参数: 无
	//返回参数: int
	@GetMapping("/borrowDay")
	public int BorrowDayTotal()
	{
		int re = service.borrowDayTotal();
		return re;
	}
	
	//功能: 当日归还量
	//输入参数: 无
	//返回参数: int
	@GetMapping("/borrowRetDay")
	public int BorrowDayRetTotal()
	{
		int re = service.borrowDayRetBorrowTotal();
		return re;
	}
	
	//功能: 当月借出量
	//输入参数: 无
	//返回参数: int
	@GetMapping("/borrowMonth")
	public int BorrowMonthTotal()
	{
		int re = service.borrowMonthTotal();
		return re;
	}
	
	//功能: 返回最近五个月的借出量
	//输入参数: 无
	//返回参数: FiveMonthData
	@GetMapping("/borrowFiveMonthData/{num}")
	public FiveMonthData BorrowFiveMonthData(@PathVariable("num") int num)
	{
		FiveMonthData re = service.borrowFiveMonthData(num);
		return re;
	}
	
	//功能: 返回最近五个月的借入量
	//输入参数: 无
	//返回参数: FiveMonthData
	//未测试使用
	@GetMapping("/borrowFiveMonthRetData/{num}")
	public FiveMonthData BorrowFiveMonthRetData(@PathVariable("num") int num)
	{
		FiveMonthData re = service.borrowFiveMonthRetData(num);
		return re;
	}
	
	//功能: 当月归还量
	//输入参数: 无
	//返回参数: int
	@GetMapping("/borrowRetMonth")
	public int BorrowMonthRetTotal()
	{
		int re = service.borrowMonthRetTotal();
		return re;
	}
	
	//功能: 当年借出量
	//输入参数: 无
	//返回参数: int
	@GetMapping("/borrowYear")
	public int BorrowYearTotal()
	{
		int re = service.borrowYearTotal();
		return re;
	}
	
	//功能: 当年归还量
	//输入参数: 无
	//返回参数: int
	@GetMapping("/borrowRetYear")
	public int BorrowYearRetTotal()
	{
		int re = service.borrowYearRetTotal();
		return re;
	}
}
