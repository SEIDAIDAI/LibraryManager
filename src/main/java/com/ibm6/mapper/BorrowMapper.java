package com.ibm6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ibm6.bean.Book;
import com.ibm6.bean.Borrow;
import com.ibm6.model.BorrowByPage;
import com.ibm6.model.BorrowDetail;
import com.ibm6.model.BorrowList;
import com.ibm6.model.UserBorrowLikeSearch;


@Mapper
public interface BorrowMapper {

	public BorrowDetail getBorrowById(int id);
	public BorrowDetail getDetailByLikeSearch(UserBorrowLikeSearch userBorrowLikeSearch);
	public List<BorrowList> selectBorrowByUserId(int userId);
	public List<Book> selectBorrowByPage(BorrowByPage borrowByPage);
}
