package com.ibm6.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Book;
import com.ibm6.bean.Borrow;
import com.ibm6.model.BookUserList;
import com.ibm6.model.BorrowBookInfo;
import com.ibm6.model.BorrowByPage;
import com.ibm6.model.BorrowDate;
import com.ibm6.model.BorrowDetail;
import com.ibm6.model.BorrowList;
import com.ibm6.model.BorrowUserInfo;
import com.ibm6.model.FiveMonthData;
import com.ibm6.model.UserBorrowLikeSearch;


@Mapper
public interface BorrowMapper {

	public BorrowDetail getBorrowById(int id);
	public List<BorrowBookInfo> getDetailByLikeSearch(UserBorrowLikeSearch userBorrowLikeSearch);
	public List<BorrowList> selectBorrowByUserId(int userId);
	public List<BorrowBookInfo> selectBorrowByUserIdAndFlag(int userId);
	public List<BorrowUserInfo> selectBorrowByPage(BorrowByPage borrowByPage);
	public int saveBorrowInfo(Borrow borrow);
	public int updateBorrowFlagAndTime(Borrow borrow);
	public int updateBookUploadInc(Borrow borrow);
	public int updateBookUploadDec(Borrow borrow);
	public List<String> getBookExists(Borrow borrow);
	public List<String> getBookHasBorrowed(Borrow borrow);
	public Book getBookLeftAmount(Borrow borrow);
	public int getDayBorrowTotal(Date today);
	public int getDayRetTotal(Date today);
	public int getMonthBorrowTotal(BorrowDate borrowMonth);
	public int getMonthRetTotal(BorrowDate borrowMonth);
	public int getYearBorrowTotal(BorrowDate borrowMonth);
	public int getYearRetTotal(BorrowDate borrowMonth);
	public int selectUserBorrowTotal(int userId);
	public String selectUserName(int userId);
	public int getDetailByLikeSearchCount(UserBorrowLikeSearch userBorrowLikeSearch);
}
