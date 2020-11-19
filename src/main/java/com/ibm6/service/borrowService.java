package com.ibm6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return mapper.getBorrowById(id);
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
	
}
