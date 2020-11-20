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
		List<BorrowList> re = mapper.selectBorrowByUserId(userId);
		return re.size();
	}
	
	public List<BorrowBookInfo> getBorrowByPage(BorrowByPage borrowByPage)
	{
		borrowByPage.setIndex(borrowByPage.getIndex() * 5);
		List<BorrowBookInfo> re = mapper.selectBorrowByPage(borrowByPage);
		return re;
	}
	
	/*
	 * int id;
	 * int userId; 
	 * int bookId; 
	 * Date borrowTime; 
 	 * Date retTime
 	 * int retFlag; 
	 * int validTime;
	 */
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
		List<String> bookIdSet = mapper.getBookExists(borrow);
		if (bookIdSet.size() > 0)
		{
			return 2;
		}
		//根据书id获取书的余量
		Book book = mapper.getBookLeftAmount(borrow);
		System.out.println("-------------------------");
		System.out.println(book);
		if (book.getLeftAmount() < 1)
		{
			return 3;
		}
		
		borrow.setBorrowTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
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
		int re1 = mapper.updateBorrowFlag(borrow);
		int re2 = mapper.updateBookUploadInc(borrow);
		if (re1 == 1 && re2 == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}	
}
