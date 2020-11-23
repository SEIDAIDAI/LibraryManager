package com.ibm6.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm6.bean.Book;
import com.ibm6.bean.Borrow;
import com.ibm6.mapper.BorrowMapper;
import com.ibm6.model.BorrowBookInfo;
import com.ibm6.model.BorrowByPage;
import com.ibm6.model.BorrowDate;
import com.ibm6.model.BorrowDetail;
import com.ibm6.model.BorrowList;
import com.ibm6.model.UserBorrowLikeSearch;

@Service
public class borrowService {

	@Autowired
	private BorrowMapper mapper;
	
	public BorrowDetail getBorrowInfo(int id) {
		BorrowDetail re =  mapper.getBorrowById(id);
		return re;
	}
	
	public List<BorrowBookInfo> getBorrowShelf(int userId)
	{
		List<BorrowBookInfo> re = mapper.selectBorrowByUserIdAndFlag(userId);
		return re;
	}
	
	public List<BorrowList> getBorrowList(int userId)
	{
		List<BorrowList> re = mapper.selectBorrowByUserId(userId);
		return re;
	}
	
	public List<BorrowBookInfo> borrowUserLikeSearch(UserBorrowLikeSearch userBorrowLikeSearch) {
		List<BorrowBookInfo> borrowDetail = mapper.getDetailByLikeSearch(userBorrowLikeSearch);
		return borrowDetail;
	}

	public int getBorrowTotal(int userId)
	{
		int re = mapper.selectUserBorrowTotal(userId);
		return re;
	}
	
	public List<BorrowBookInfo> getBorrowByPage(BorrowByPage borrowByPage)
	{
		borrowByPage.setIndex(borrowByPage.getIndex() * 5);
		List<BorrowBookInfo> re = mapper.selectBorrowByPage(borrowByPage);
		return re;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int borrowBook(Borrow borrow)
	{
		//保存的信息
		/*
		 * int userId; 
		 * int bookId; 
		 * 
		 * Date borrowTime; //系统当前时间
	 	 * Date retTime   // 当前时间 + 借阅天数  = 归还时间
	 	 * int retFlag;   //设置为 1
		 * int validTime;  //用户借阅的天数  默认是一个月  当时候要看一下  一月31  能否到二月末   用户界面是否显示正确
		 */
		//获取系统当前时间
		
		//根据用户id得到所有的书  判断这本书的id是否在里面
		//是否已借
		List<String> bookIdSet = mapper.getBookExists(borrow);
		if (bookIdSet.size() > 0)
		{
			return 2;
		}
		
		//是否已借三本书
		List<String> bookHasBorrowed = mapper.getBookHasBorrowed(borrow);
		if (bookHasBorrowed.size() >= 3)
		{
			return 3;
		}
		

		//根据书id获取书的余量
		//是否有库存
		Book book = mapper.getBookLeftAmount(borrow);
		if (book.getLeftAmount() < 1)
		{
			return 4;
		}
		
		borrow.setBorrowTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.set(1970, 0, 1);  //月份从0开始
		borrow.setRetTime(cal.getTime());
		int re1 = mapper.saveBorrowInfo(borrow);
		int re2 = mapper.updateBookUploadDec(borrow);
		if (re1 == 1 && re2 == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	//是否需要进行事务控制
	//否则会  某一个操作 某一个操作不成功
	@Transactional(rollbackFor = Exception.class)
	public int borrowReturn(Borrow borrow)
	{
		borrow.setRetTime(Calendar.getInstance().getTime());
		int re1 = mapper.updateBorrowFlagAndTime(borrow);  //记录也应该是存在的  用来检测其他逻辑是否会出现一些错误的逻辑
		if (re1 == 0)
			return 2;
		int re2 = mapper.updateBookUploadInc(borrow);  //书是肯定存在的
		if (re2 == 1) {
			return 1;
		}
		return 0;
	}	
	
	public Date getBorrowDay()
	{
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public int borrowDayTotal()
	{
		int total = mapper.getDayBorrowTotal(getBorrowDay());
		return total;
	}
	
	public int borrowDayRetBorrowTotal() 
	{ 
		System.out.println(getBorrowDay());
		int total = mapper.getDayRetTotal(getBorrowDay()); 
		return total; 
	}
	
	public BorrowDate getBorrowMonth()
	{
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(calendar.getTime());
		BorrowDate borrowDate = new BorrowDate();
		borrowDate.setStart(calendar.getTime());
		borrowDate.setToday(new Date());
		return borrowDate;
	}
	 
	public int borrowMonthTotal() 
	{
		//这个月的开始 至 今天
		//between and  需要两个时间
		//2020-11-01 00:00:00   
		//2021-11-21 11:29:23 

		int re = mapper.getMonthBorrowTotal(getBorrowMonth());
		return re;
	}
	  
	public int borrowMonthRetTotal()
	{
		int re = mapper.getMonthRetTotal(getBorrowMonth());
		return re;
	}
	
	public BorrowDate getBorrowYear()
	{
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(calendar.getTime());
		
		BorrowDate borrowDate = new BorrowDate();
		borrowDate.setStart(calendar.getTime());
		borrowDate.setToday(new Date());

		return borrowDate;
	}
	
	public int borrowYearTotal()
	{
		//年的开始 至  今天
		//between and  需要两个时间
		//2020-01-01 00:00:00   
		//2021-11-21 11:29:23	 
		
		int re = mapper.getYearBorrowTotal(getBorrowYear());
		return re;
	}
	
	public int borrowYearRetTotal()
	{		
		int re = mapper.getYearRetTotal(getBorrowYear());
		return re;
	}
}
